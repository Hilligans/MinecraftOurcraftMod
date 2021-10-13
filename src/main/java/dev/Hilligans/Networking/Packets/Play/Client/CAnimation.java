package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CAnimation extends PacketBase {

    public int hand;

    public CAnimation(int hand) {
        this.hand = hand;
    }

    public CAnimation() {}

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
