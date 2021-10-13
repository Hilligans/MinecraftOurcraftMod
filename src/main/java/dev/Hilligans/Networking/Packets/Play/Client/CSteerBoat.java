package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSteerBoat extends PacketBase {

    public boolean paddleLeft;
    public boolean paddleRight;

    public CSteerBoat(boolean paddleLeft, boolean paddleRight) {
        this.paddleLeft = paddleLeft;
        this.paddleRight = paddleRight;
    }

    public CSteerBoat() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeBoolean(paddleLeft);
        packetData.writeBoolean(paddleRight);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
