package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SDestroyEntities extends PacketBase {

    public int destroyCount;
    public int[] idsToDestroy;


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        destroyCount = packetData.readVarInt();
        idsToDestroy = packetData.readVarInts(destroyCount);
    }

    @Override
    public void handle() {

    }
}
