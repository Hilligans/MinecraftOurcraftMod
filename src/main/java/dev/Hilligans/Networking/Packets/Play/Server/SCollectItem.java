package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SCollectItem extends PacketBase {

    public int itemID;
    public int collectorID;
    public int pickupCount;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        itemID = packetData.readVarInt();
        collectorID = packetData.readVarInt();
        pickupCount = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
