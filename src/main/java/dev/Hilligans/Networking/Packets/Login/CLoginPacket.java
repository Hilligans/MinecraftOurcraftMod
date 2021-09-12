package dev.Hilligans.Networking.Packets.Login;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

public class CLoginPacket extends PacketBase {

    public String name;

    public CLoginPacket(){}

    public CLoginPacket(String name) {
        this.name = name;
    }

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
