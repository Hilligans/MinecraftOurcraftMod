package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class STabComplete extends PacketBase {

    public int id;
    public int start;
    public int length;
    public int count;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        id = packetData.readVarInt();
        start = packetData.readVarInt();
        length = packetData.readVarInt();
        count = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
