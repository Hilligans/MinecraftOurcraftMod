package dev.Hilligans.Networking.Packets.Login;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.Main;
import dev.Hilligans.Networking.Other.HTTP.HTTPUtil;
import dev.Hilligans.Networking.Other.Pipelines.NettyEncryptingDecoder;
import dev.Hilligans.Networking.Other.Pipelines.NettyEncryptingEncoder;
import dev.Hilligans.Util.CryptManager;
import org.json.JSONObject;

import javax.crypto.*;
import java.math.BigInteger;
import java.security.PublicKey;

public class SEncryptionRequest extends PacketBase {

    String serverID;
    PublicKey publicKey;
    byte[] verifyToken;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        serverID = packetData.readUTF8();
        int length = packetData.readVarInt();
        publicKey = CryptManager.decodePublicKey(packetData.readBytes(length));
        length = packetData.readVarInt();
        verifyToken = packetData.readBytes(length);
    }

    @Override
    public void handle() {
        SecretKey secretkey = CryptManager.createNewSharedKey();
        String s = (new BigInteger(CryptManager.getServerIdHash(serverID, publicKey, secretkey))).toString(16);
        CEncryptionRequest packet = new CEncryptionRequest(secretkey, publicKey, verifyToken);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("selectedProfile",Main.UUID);
        jsonObject.put("accessToken",Main.accessToken);
        jsonObject.put("serverId",s);

        try {
            HTTPUtil.sendContent("https://sessionserver.mojang.com/session/minecraft/join", jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main.network.sendPacket(packet);
        Main.network.channelPipeline.addBefore("encoder","encrypt",new NettyEncryptingEncoder(CryptManager.getCipherInstance(1, secretkey)));
        Main.network.channelPipeline.addBefore("decoder","decrypt",new NettyEncryptingDecoder(CryptManager.getCipherInstance(2, secretkey)));

    }


}
