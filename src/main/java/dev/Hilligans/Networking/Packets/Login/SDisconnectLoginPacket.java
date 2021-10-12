package dev.Hilligans.Networking.Packets.Login;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

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
