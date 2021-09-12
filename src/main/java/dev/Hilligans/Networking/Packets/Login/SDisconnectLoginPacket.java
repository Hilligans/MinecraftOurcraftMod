package dev.Hilligans.Networking.Packets.Login;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

public class SDisconnectLoginPacket extends PacketBase {

    public SDisconnectLoginPacket() {
    }

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
