package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSpawnExperienceOrb extends PacketBase {

    public int entityID;
    public double x;
    public double y;
    public double z;
    public short count;

    @Override
    public void encode(PacketData packetData) {
    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        count = packetData.readShort();
    }

    @Override
    public void handle() {

    }
}
