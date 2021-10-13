package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CClientStatus extends PacketBase {

    public int actionID;

    public CClientStatus(int actionID) {
        this.actionID = actionID;
    }

    public CClientStatus() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(actionID);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
