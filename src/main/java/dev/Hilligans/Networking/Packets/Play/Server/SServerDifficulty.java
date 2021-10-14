package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SServerDifficulty extends PacketBase {

    public short difficulty;
    public boolean locked;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        difficulty = packetData.readUnsignedByte();
        locked = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
