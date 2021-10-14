package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

import java.util.UUID;

public class SSpawnPlayer extends PacketBase {

    public int id;
    public UUID uuid;
    public double x;
    public double y;
    public double z;
    public byte pitch,yaw;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        id = packetData.readVarInt();
        uuid = UUID.nameUUIDFromBytes(packetData.readBytes(16));
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        yaw = packetData.readByte();
        pitch = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
