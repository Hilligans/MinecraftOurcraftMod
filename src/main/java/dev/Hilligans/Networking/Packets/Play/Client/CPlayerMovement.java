package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerMovement extends PacketBase {

    public boolean onGround;

    public CPlayerMovement(boolean onGround) {
        this.onGround = onGround;
    }

    public CPlayerMovement() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeBoolean(onGround);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
