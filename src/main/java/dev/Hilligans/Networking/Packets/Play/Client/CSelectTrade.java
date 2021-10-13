package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSelectTrade extends PacketBase {

    public int slot;

    public CSelectTrade(int slot) {
        this.slot = slot;
    }

    public CSelectTrade() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(slot);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
