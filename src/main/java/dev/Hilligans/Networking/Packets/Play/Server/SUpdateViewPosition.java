package dev.Hilligans.Networking.Packets.Play.Server;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

public class SUpdateViewPosition extends PacketBase {
    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        System.out.println("ChunkX " + packetData.readVarInt());
    }

    @Override
    public void handle() {

    }
}
