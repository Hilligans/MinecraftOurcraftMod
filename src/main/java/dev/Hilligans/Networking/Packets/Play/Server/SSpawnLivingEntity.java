package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

import java.util.UUID;

public class SSpawnLivingEntity extends PacketBase {

    public int id;
    public UUID uuid;
    public int type;
    public double x;
    public double y;
    public double z;
    public byte pitch,yaw;
    public byte headPitch;
    public short velX,velY,velZ;

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
        yaw = packetData.readByte();
        pitch = packetData.readByte();
        headPitch = packetData.readByte();
        velX = packetData.readShort();
        velY = packetData.readShort();
        velZ = packetData.readShort();
    }

    @Override
    public void handle() {

    }
}
