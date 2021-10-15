package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SUpdateViewPosition extends PacketBase {

    public int chunkX;
    public int chunkZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        chunkX = packetData.readVarInt();
        chunkZ = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
