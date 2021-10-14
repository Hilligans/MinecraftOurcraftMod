package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SParticle extends PacketBase {

    public int particleID;
    public boolean longDistance;
    public double x;
    public double y;
    public double z;
    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public float particleData;
    public int particleCount;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        particleID = packetData.readInt();
        longDistance = packetData.readBoolean();
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        offsetX = packetData.readFloat();
        offsetY = packetData.readFloat();
        offsetZ = packetData.readFloat();
        particleData = packetData.readFloat();
        particleCount = packetData.readInt();
        //need to read particle data
    }

    @Override
    public void handle() {

    }
}
