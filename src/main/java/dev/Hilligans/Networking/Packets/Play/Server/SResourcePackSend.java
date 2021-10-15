package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SResourcePackSend extends PacketBase {

    public String url;
    public String hash;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        url = packetData.readUTF8();
        hash = packetData.readUTF8();
    }

    @Override
    public void handle() {

    }
}
