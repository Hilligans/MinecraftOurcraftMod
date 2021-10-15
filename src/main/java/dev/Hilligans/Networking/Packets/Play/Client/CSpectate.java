package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSpectate extends PacketBase {

    public long[] uuid;

    public CSpectate(long[] uuid) {
        this.uuid = uuid;
    }

    public CSpectate() {}

    @Override
    public void encode(PacketData packetData) {
        for(long val : uuid) {
            packetData.writeLong(val);
        }
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
