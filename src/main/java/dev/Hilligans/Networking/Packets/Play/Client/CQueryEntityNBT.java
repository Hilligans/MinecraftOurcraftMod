package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CQueryEntityNBT extends PacketBase {

    public int transactionID;
    public int entityID;

    public CQueryEntityNBT(int transactionID, int entityID) {
        this.transactionID = transactionID;
        this.entityID = entityID;
    }

    public CQueryEntityNBT() {}

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
