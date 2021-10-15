package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SUpdateViewDistance extends PacketBase {

    public int viewDistance;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        viewDistance = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
