package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityTeleport extends PacketBase {

    public int entityID;
    public double x;
    public double y;
    public double z;
    public byte yaw;
    public byte pitch;
    public boolean onGround;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        yaw = packetData.readByte();
        pitch = packetData.readByte();
        onGround = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
