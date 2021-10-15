package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSelectAdvancementTab extends PacketBase {

    public String identifier;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        if(packetData.readBoolean()) {
            identifier = packetData.readUTF8();
        }
    }

    @Override
    public void handle() {

    }
}
