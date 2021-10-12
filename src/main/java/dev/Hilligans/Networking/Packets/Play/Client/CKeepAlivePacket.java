package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.Main;

public class CKeepAlivePacket extends PacketBase {

    long id;

    public CKeepAlivePacket() {}

    public CKeepAlivePacket(long id) {
        this.id = id;
    }

    @Override
    public void encode(PacketData packetData) {
        packetData.writeLong(id);
    }

    @Override
    public void decode(PacketData packetData) {
    }

    @Override
    public void handle() {

    }
}
