package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSetPassengers extends PacketBase {

    public int entityID;
    public int[] passengerIDs;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        passengerIDs = packetData.readVarInts(packetData.readVarInt());
    }

    @Override
    public void handle() {

    }
}
