package dev.Hilligans.Networking.Packets.Status;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

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
