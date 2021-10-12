package dev.Hilligans.Networking.Packets.Login;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.Util.CryptManager;

import javax.crypto.SecretKey;
import java.security.PublicKey;

public class CEncryptionRequest extends PacketBase {

    private byte[] secretKeyEncrypted = new byte[0];
    private byte[] verifyTokenEncrypted = new byte[0];

    public CEncryptionRequest() {}

    public CEncryptionRequest(SecretKey secret, PublicKey key, byte[] verifyToken) {
        this.secretKeyEncrypted = CryptManager.encryptData(key, secret.getEncoded());
        this.verifyTokenEncrypted = CryptManager.encryptData(key, verifyToken);
    }


    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(secretKeyEncrypted.length);
        packetData.byteBuf.writeBytes(secretKeyEncrypted);
        packetData.writeVarInt(verifyTokenEncrypted.length);
        packetData.byteBuf.writeBytes(verifyTokenEncrypted);
        packetData.size = packetData.byteBuf.writerIndex();
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
