package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CUseItem extends PacketBase {

    public int hand;

    public CUseItem(int hand) {
        this.hand = hand;
    }

    public CUseItem() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(hand);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
