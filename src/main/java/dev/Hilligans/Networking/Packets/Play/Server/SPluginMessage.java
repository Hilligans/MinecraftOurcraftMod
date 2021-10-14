package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SPluginMessage extends PacketBase {

    public String channel;
    public byte[] data;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        channel = packetData.readUTF8();
    }

    @Override
    public void handle() {

    }
}
