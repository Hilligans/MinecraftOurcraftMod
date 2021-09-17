package dev.Hilligans;

import Hilligans.Block.Block;
import Hilligans.Client.Rendering.ScreenBase;
import Hilligans.Client.Rendering.Widgets.Button;
import Hilligans.ClientMain;
import Hilligans.ModHandler.Content.ModContent;
import Hilligans.ModHandler.Events.Client.ClientSendMessageEvent;
import Hilligans.ModHandler.Events.Client.ClientStartRenderingEvent;
import Hilligans.ModHandler.Events.Client.RenderWorldEvent;
import Hilligans.ModHandler.Mod;
import Hilligans.Network.*;
import Hilligans.Ourcraft;
import Hilligans.WorldSave.WorldLoader;
import dev.Hilligans.Networking.Other.EmptyPacket;
import dev.Hilligans.Networking.Other.HTTP.HTTPUtil;
import dev.Hilligans.Networking.Other.Pipelines.MinecraftPacketDecoder;
import dev.Hilligans.Networking.Other.Pipelines.MinecraftPacketEncoder;
import dev.Hilligans.Networking.Packets.Handshake.CHandshakePacket;
import dev.Hilligans.Networking.Packets.Login.*;
import dev.Hilligans.Networking.Packets.Play.Client.CKeepAlivePacket;
import dev.Hilligans.Networking.Packets.Play.Client.CPlayerPosition;
import dev.Hilligans.Networking.Packets.Play.Client.CSendChatMessage;
import dev.Hilligans.Networking.Packets.Play.Client.CTeleportConfirm;
import dev.Hilligans.Networking.Packets.Play.Server.*;
import dev.Hilligans.Networking.Packets.Status.CQueryPacket;
import dev.Hilligans.Networking.Packets.Status.SServerList;
import dev.Hilligans.Util.BlockManager;
import dev.Hilligans.Util.BlockModelParser;
import dev.Hilligans.Util.ProtocolVersion;
import dev.Hilligans.Util.VersionTable;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Mod(modID = "MinecraftOurcraft")
public class Main {

    //1.16.5
    public static int version = 754 ;
    public static ClientNetwork network;
    public static ModContent modContent;

    public static String ip = "synergyserver.net";
    public static int port = 25565;

    public static String accessToken;
    public static String UUID;
    public static int messageID;

    public static boolean authenticated = false;

    public static VersionTable versionTable;
    public static ProtocolVersion protocolVersion;

    public Main(ModContent modContent) {
        Main.modContent = modContent;

        versionTable = new VersionTable("/Versions/Blocks/1.16.5.json");
        protocolVersion = new ProtocolVersion("/Versions/Protocols/1.16.5.json");

        modContent.blockParser = (blockData, string) -> {
            Block block = new Block(string, "/MinecraftOurcraft/Data/" + blockData.optString("data","Blocks/block.json"), modContent.modID,null);
            JSONArray textures = blockData.getJSONArray("textures");
            for(int x = 0; x < textures.length(); x++) {
                block.blockProperties.addTexture(textures.getString(x),x,textures.length());
            }
            int a = 0;
            for(int x : versionTable.blockNetworkIDs.get(block.name)) {
                BlockManager.register(x,a,block);
                a++;
            }
            return block;
        };


        Ourcraft.EVENT_BUS.register(ClientSendMessageEvent.class, clientSendMessageEvent -> network.sendPacket(new CSendChatMessage(clientSendMessageEvent.message)));
        Ourcraft.EVENT_BUS.register(RenderWorldEvent.class,this::draw);
        Ourcraft.EVENT_BUS.register(ClientStartRenderingEvent.class,this::event);
        modContent.registerPacket("MinecraftHandshake",0, CHandshakePacket::new);
        modContent.registerPacket("MinecraftStatusClientBound",0, SServerList::new);
        modContent.registerPacket("MinecraftStatusServerBound",0, CQueryPacket::new);
        modContent.registerPacket("MinecraftLoginServerBound",0, CLoginPacket::new);
        modContent.registerPacket("MinecraftLoginServerBound",1, CEncryptionRequest::new);
        modContent.registerPacket("MinecraftLoginClientBound",0, SDisconnectLoginPacket::new);
        modContent.registerPacket("MinecraftLoginClientBound",1, SEncryptionRequest::new);
        modContent.registerPacket("MinecraftLoginClientBound",2, SLoginSuccess::new);
        modContent.registerPacket("MinecraftLoginClientBound",3, SSetCompression::new);
        modContent.registerPacket("MinecraftLoginClientBound",4, SLoginPluginRequest::new);


        modContent.registerPacket("MinecraftPlayClientBound",14, SSendChatMessage::new);
        modContent.registerPacket("MinecraftPlayClientBound",25, SDisconnectPlayPacket::new);
        modContent.registerPacket("MinecraftPlayClientBound",31, SKeepAlivePacket::new);
        modContent.registerPacket("MinecraftPlayClientBound",32, SChunkDataPacket::new);
        modContent.registerPacket("MinecraftPlayClientBound",52, SPlayerPositionAndLookPacket::new);
        modContent.registerPacket("MinecraftPlayClientBound",72,SUpdateViewPosition::new);
        for(int x = 0; x < 200; x++) {
            modContent.registerPacket("MinecraftPlayClientBound",x, EmptyPacket::new);
        }

        modContent.registerPacket("MinecraftPlayServerBound",0, CTeleportConfirm::new);
        modContent.registerPacket("MinecraftPlayServerBound",3, CSendChatMessage::new);
        modContent.registerPacket("MinecraftPlayServerBound",16, CKeepAlivePacket::new);
        modContent.registerPacket("MinecraftPlayServerBound",18,CPlayerPosition::new);

        BlockModelParser.getBlockModel(new JSONObject(WorldLoader.readString("/minecraft/models/block/button.json")));
    }

    long time;
    public void draw(RenderWorldEvent event) {
        if(ClientMain.getClient().renderWorld ) {
            try {
                if(System.currentTimeMillis() - time > 1000) {
                    time = System.currentTimeMillis();
                }
            } catch (Exception ignored) {}
        }
    }

    public void event(ClientStartRenderingEvent event) {
        try {
            HTTPUtil.sendContent("https://authserver.mojang.com/authenticate",HTTPUtil.buildString(Main.readString("email.txt"),Main.readString("password.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        network = new ClientNetwork(modContent.protocols.get("MinecraftHandshake"),modContent.protocols.get("MinecraftLoginClientBound"),1) {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("encoder", new MinecraftPacketEncoder(packetIdWidth,compressed));
                pipeline.addLast("decoder", new MinecraftPacketDecoder(packetIdWidth,compressed));
                pipeline.addLast("handler", networkHandler);
                channelPipeline = pipeline;
            }
        };
        try {
            network.joinServer(ip, port + "", ClientMain.getClient());

        } catch (Exception e) {
            e.printStackTrace();
        }

        ((ScreenBase)ClientMain.getClient().screen).addWidget(new Button(800, 500, 50, 50, "Play", () -> {
            network.sendPacket(new CHandshakePacket(ip, port,2));
            network.sendProtocol = modContent.protocols.get("MinecraftLoginServerBound");
            network.sendPacket((new CLoginPacket("hilligans")));
        }));
    }

    public static String readString(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream stream = Main.class.getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            System.out.println("Cant read file: " + path);
            return "";
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            reader.lines().forEach((string) -> {
                stringBuilder.append(string).append("\n");
            });
            return stringBuilder.toString().trim();
        }
    }
}
