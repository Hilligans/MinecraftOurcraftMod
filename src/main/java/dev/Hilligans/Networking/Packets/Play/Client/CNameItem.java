package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CNameItem extends PacketBase {

    public String name;

    public CNameItem(String name) {
        this.name = name;
    }

    public CNameItem() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeUTF8(name);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
