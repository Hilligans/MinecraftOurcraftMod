package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

import java.util.UUID;
import java.util.zip.Deflater;

public class SSpawnEntity extends PacketBase {

    int id;
    UUID uuid;
    int type;
    double x,y,z;
    byte pitch,yaw;
    int data;
    short velX,velY,velZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        id = packetData.readVarInt();
        uuid = UUID.nameUUIDFromBytes(packetData.readBytes(16));
        type = packetData.readVarInt();
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        pitch = packetData.readByte();
        yaw = packetData.readByte();
        data = packetData.readInt();
        velX = packetData.readShort();
        velY = packetData.readShort();
        velZ = packetData.readShort();
    }

    @Override
    public void handle() {
        System.out.println("handling");
    }
}
