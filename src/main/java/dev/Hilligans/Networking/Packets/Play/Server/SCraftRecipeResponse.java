package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SCraftRecipeResponse extends PacketBase {

    public byte windowID;
    public String recipe;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readByte();
        recipe = packetData.readUTF8();
    }

    @Override
    public void handle() {

    }
}
