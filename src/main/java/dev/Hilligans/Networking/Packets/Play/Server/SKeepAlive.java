package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.Main;
import dev.Hilligans.Networking.Packets.Play.Client.CKeepAlive;

public class SKeepAlive extends PacketBase {

    long id;
    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        id = packetData.readLong();
    }

    @Override
    public void handle() {
        Main.network.sendPacket(new CKeepAlive(id));
    }
}
