package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SDisconnectPlayPacket extends PacketBase {
    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        System.out.println("Disconnected " + packetData.readUTF8());
    }

    @Override
    public void handle() {

    }
}
