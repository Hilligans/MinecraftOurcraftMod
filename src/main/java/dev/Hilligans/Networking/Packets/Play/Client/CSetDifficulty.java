package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSetDifficulty extends PacketBase {

    public byte difficulty;

    public CSetDifficulty(byte difficulty) {
        this.difficulty = difficulty;
    }

    public CSetDifficulty() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(difficulty);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
