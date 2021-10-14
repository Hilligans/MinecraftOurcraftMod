package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SUnloadChunk extends PacketBase {

    public int chunkX;
    public int chunkZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        chunkX = packetData.readInt();
        chunkZ = packetData.readInt();
    }

    @Override
    public void handle() {

    }
}
