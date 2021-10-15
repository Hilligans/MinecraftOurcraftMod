package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SMultiBlockChange extends PacketBase {

    public long chunkSectionPosition;
    public boolean trustEdgesInverse;
    public long[] blockChanges;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        chunkSectionPosition = packetData.readLong();
        trustEdgesInverse = packetData.readBoolean();
        blockChanges = packetData.readVarLongs(packetData.readVarInt());
    }

    @Override
    public void handle() {

    }
}
