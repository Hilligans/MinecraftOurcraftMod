package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SStatistics extends PacketBase {

    public int count;
    public int[] statistics;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        count = packetData.readVarInt();
        statistics = new int[count];
        for(int x = 0; x < count; x++) {
            statistics[x] = packetData.readVarInt();
        }
    }

    @Override
    public void handle() {

    }
}
