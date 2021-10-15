package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SDisplayScoreboard extends PacketBase {

    public byte position;
    public String scoreName;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        position = packetData.readByte();
        scoreName = packetData.readUTF8();
    }

    @Override
    public void handle() {

    }
}
