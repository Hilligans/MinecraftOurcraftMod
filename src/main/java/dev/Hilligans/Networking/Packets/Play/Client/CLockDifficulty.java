package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CLockDifficulty extends PacketBase {

    public boolean locked;

    public CLockDifficulty(boolean locked) {
        this.locked = locked;
    }

    public CLockDifficulty() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeBoolean(locked);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
