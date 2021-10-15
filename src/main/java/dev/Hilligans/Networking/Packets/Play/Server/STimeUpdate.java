package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class STimeUpdate extends PacketBase {

    public long worldAge;
    public long timeOfDay;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        worldAge = packetData.readLong();
        timeOfDay = packetData.readLong();
    }

    @Override
    public void handle() {

    }
}
