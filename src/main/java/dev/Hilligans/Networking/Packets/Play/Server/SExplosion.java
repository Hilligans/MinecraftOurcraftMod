package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SExplosion extends PacketBase {

    public float x;
    public float y;
    public float z;
    public float strength;
    public int recordCount;
    public byte[] records;
    public float motionX;
    public float motionY;
    public float motionZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        x = packetData.readFloat();
        y = packetData.readFloat();
        z = packetData.readFloat();
        strength = packetData.readFloat();
        recordCount = packetData.readInt();
        records = packetData.readBytes(recordCount * 3);
        motionX = packetData.readFloat();
        motionY = packetData.readFloat();
        motionZ = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
