package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class STeams extends PacketBase {

    //TODO finish
    public String name;
    public byte mode;


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        name = packetData.readUTF8();
        mode = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
