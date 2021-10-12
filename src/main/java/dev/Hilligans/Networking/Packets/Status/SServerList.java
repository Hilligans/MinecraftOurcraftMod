package dev.Hilligans.Networking.Packets.Status;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SServerList extends PacketBase {

    public SServerList() {}

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        System.out.println(packetData.readUTF8());
    }

    @Override
    public void handle() {

    }
}
