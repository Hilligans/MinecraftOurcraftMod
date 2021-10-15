package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SPlayerPositionAndLook extends PacketBase {

    public double x;
    public double y;
    public double z;
    public float yaw;
    public float pitch;
    public byte flags;
    public int teleportID;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        yaw = packetData.readFloat();
        pitch = packetData.readFloat();
        flags = packetData.readByte();
        teleportID = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
