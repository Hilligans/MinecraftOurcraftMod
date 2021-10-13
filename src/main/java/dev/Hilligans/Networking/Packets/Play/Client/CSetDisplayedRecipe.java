package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSetDisplayedRecipe extends PacketBase {

    public String identifier;

    public CSetDisplayedRecipe(String identifier) {
        this.identifier = identifier;
    }

    public CSetDisplayedRecipe() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeUTF8(identifier);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
