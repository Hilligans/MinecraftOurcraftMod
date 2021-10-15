package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Util.UUID;

import java.util.zip.Deflater;

public class SSpawnEntity extends PacketBase {

    public int id;
    public UUID uuid;
    public int type;
    public double x,y,z;
    public byte pitch,yaw;
    public int data;
    public short velX,velY,velZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        id = packetData.readVarInt();
        uuid = new UUID(packetData);
        type = packetData.readVarInt();
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        yaw = packetData.readByte();
        pitch = packetData.readByte();
        data = packetData.readInt();
        velX = packetData.readShort();
        velY = packetData.readShort();
        velZ = packetData.readShort();
    }

    @Override
    public void handle() {
    }
}
