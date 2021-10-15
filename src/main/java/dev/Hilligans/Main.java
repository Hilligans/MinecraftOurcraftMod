package dev.Hilligans;

import dev.Hilligans.Networking.Packets.PacketList;
import dev.Hilligans.ourcraft.Block.Block;
import dev.Hilligans.ourcraft.Client.Camera;
import dev.Hilligans.ourcraft.Client.Key.KeyHandler;
import dev.Hilligans.ourcraft.Client.Key.KeyPress;
import dev.Hilligans.ourcraft.Client.Rendering.ScreenBase;
import dev.Hilligans.ourcraft.Client.Rendering.Widgets.Button;
import dev.Hilligans.ourcraft.Client.ScreenShot;
import dev.Hilligans.ourcraft.ClientMain;
import dev.Hilligans.ourcraft.ModHandler.Content.ModContent;
import dev.Hilligans.ourcraft.ModHandler.Events.Client.*;
import dev.Hilligans.ourcraft.ModHandler.Mod;
import dev.Hilligans.ourcraft.Network.*;
import dev.Hilligans.ourcraft.Util.Settings;
import dev.Hilligans.ourcraft.WorldSave.WorldLoader;
import dev.Hilligans.Networking.Other.EmptyPacket;
import dev.Hilligans.Networking.Other.HTTP.HTTPUtil;
import dev.Hilligans.Networking.Other.Pipelines.MinecraftPacketDecoder;
import dev.Hilligans.Networking.Other.Pipelines.MinecraftPacketEncoder;
import dev.Hilligans.Networking.Packets.Handshake.CHandshakePacket;
import dev.Hilligans.Networking.Packets.Login.*;
import dev.Hilligans.Networking.Packets.Play.Client.CPlayerPosition;
import dev.Hilligans.Networking.Packets.Play.Client.CChatMessage;
import dev.Hilligans.Networking.Packets.Play.Server.*;
import dev.Hilligans.Networking.Packets.Status.CQueryPacket;
import dev.Hilligans.Networking.Packets.Status.SServerList;
import dev.Hilligans.Util.*;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lwjgl.opengl.GL30;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.lwjgl.opengl.GL11.*;

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
    public static int maxChunks = 250;

    public static boolean authenticated = false;

    public static VersionTable versionTable;
    public static ProtocolVersion protocolVersion;

    public boolean takeScreenShot = false;

    public Main(ModContent modContent) {
        Settings.worldName = ip;

        Thread thread = new Thread(() -> {
            try {
                HTTPUtil.sendContent("https://authserver.mojang.com/authenticate",HTTPUtil.buildString(Main.readString("email.txt"),Main.readString("password.txt")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.setName("minecraft_authenticate");
        thread.start();
        Main.modContent = modContent;
        Settings.requestChunks = false;
        ChunkProcessor.create();

        try {
            versionTable = new VersionTable("/Versions/Blocks/1.16.5.json");
        } catch (Exception e) {
            versionTable = new VersionTable("Versions/Blocks/1.16.5.json");
        }
        try {
            protocolVersion = new ProtocolVersion("/Versions/Protocols/1.16.5.json");
        } catch(Exception e) {
            protocolVersion = new ProtocolVersion("Versions/Protocols/1.16.5.json");
        }

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
        modContent.gameInstance.EVENT_BUS.register(ClientSendMessageEvent.class, clientSendMessageEvent -> network.sendPacket(new CChatMessage(clientSendMessageEvent.message)));
        modContent.gameInstance.EVENT_BUS.register(RenderWorldEvent.class,this::draw);
        modContent.gameInstance.EVENT_BUS.register(ClientStartRenderingEvent.class,this::event);
        modContent.gameInstance.EVENT_BUS.register(RenderPreEvent.class,this::pre);
        modContent.gameInstance.EVENT_BUS.register(RenderStartEvent.class,this::start);
        modContent.gameInstance.EVENT_BUS.register(RenderPostEvent.class,this::end);

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

        //PacketList.putIntoProtocol("MinecraftPlayClientBound",protocolVersion.protocol.get("MinecraftPlayClientBound"),modContent);


        modContent.registerPacket("MinecraftPlayClientBound",14, SChatMessage::new);
        modContent.registerPacket("MinecraftPlayClientBound",25, SDisconnectPlayPacket::new);
        modContent.registerPacket("MinecraftPlayClientBound",31, SKeepAlive::new);
        modContent.registerPacket("MinecraftPlayClientBound",32, SChunkData::new);
        modContent.registerPacket("MinecraftPlayClientBound",52, SPlayerPositionAndLookPacket::new);
        modContent.registerPacket("MinecraftPlayClientBound",72,SUpdateViewPosition::new);
        for(int x = 0; x < 200; x++) {
            modContent.registerPacket("MinecraftPlayClientBound",x, EmptyPacket::new);
        }



        PacketList.putIntoProtocol("MinecraftPlayServerBound",protocolVersion.protocol.get("MinecraftPlayServerBound"),modContent);

     //   modContent.registerPacket("MinecraftPlayServerBound",0, CTeleportConfirm::new);
     //   modContent.registerPacket("MinecraftPlayServerBound",3, CChatMessage::new);
   ////     modContent.registerPacket("MinecraftPlayServerBound",16, CKeepAlive::new);
    //    modContent.registerPacket("MinecraftPlayServerBound",18,CPlayerPosition::new);

        BlockModelParser.getBlockModel(new JSONObject(WorldLoader.readString("/minecraft/models/block/button.json")));
    }

    long time;
    public void draw(RenderWorldEvent event) {
        KeyHandler.register(new KeyPress() {
            @Override
            public void onPress() {
                takeScreenShot = true;
            }
        },KeyHandler.GLFW_KEY_F7);
        KeyHandler.register(new KeyPress() {
            @Override
            public void onPress() {
                System.out.println();
            }
        },KeyHandler.GLFW_KEY_KP_4);
        Camera.moveSpeed = 0.1f;
        if(ClientMain.getClient().renderWorld ) {
            try {
                if(System.currentTimeMillis() - time > 50) {
                    time = System.currentTimeMillis();
                    network.sendPacket(new CPlayerPosition(Camera.pos.x,Camera.pos.y,Camera.pos.z));
                }
            } catch (Exception ignored) {}
        }
    }

    static int width = 1920 * 16;
    static int height = 1080 * 16;

    static int renderDistance = 8;
    static int buffer = -1;
    static int texture = -1;
    public void pre(RenderPreEvent event) {
        if(takeScreenShot) {
            renderDistance = Settings.renderDistance;
            Settings.renderDistance = 512;
            ClientMain.getClient().windowX = width;
            ClientMain.getClient().windowY = height;
            ScreenShot.largeScreenshot(width,height,ClientMain.getClient());
        }
    }

    public void start(RenderStartEvent event) {
        if(takeScreenShot) {
        }
    }

    public void end(RenderPostEvent event) {
        if(takeScreenShot) {
            takeScreenShot = false;
            Settings.renderDistance = renderDistance;
        }
    }

    public void event(ClientStartRenderingEvent event) {
        System.out.println(glGetInteger(GL30.GL_MAX_VIEWPORT_DIMS));
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
            while (!authenticated) {}
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

    static {
        PacketList.registerPackets();
    }
}
