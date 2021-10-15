package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SPlayerListHeaderAndFooter extends PacketBase {

    public String header;
    public String footer;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        header = packetData.readUTF8();
        footer = packetData.readUTF8();
    }

    @Override
    public void handle() {

    }
}
