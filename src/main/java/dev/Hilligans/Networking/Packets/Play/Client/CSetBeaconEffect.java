package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSetBeaconEffect extends PacketBase {

    public int primaryEffect;
    public int secondaryEffect;

    public CSetBeaconEffect(int primaryEffect, int secondaryEffect) {
        this.primaryEffect = primaryEffect;
        this.secondaryEffect = secondaryEffect;
    }

    public CSetBeaconEffect() {}


    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(primaryEffect);
        packetData.writeVarInt(secondaryEffect);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
