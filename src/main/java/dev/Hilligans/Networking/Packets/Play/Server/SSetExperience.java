package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSetExperience extends PacketBase {

    public float experienceBar;
    public int level;
    public int totalXP;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        experienceBar = packetData.readFloat();
        level = packetData.readVarInt();
        totalXP = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
