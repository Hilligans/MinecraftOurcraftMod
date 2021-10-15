package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SOpenWindow extends PacketBase {

    public int windowID;
    public int windowType;
    public String chatMessage;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readVarInt();
        windowType = packetData.readVarInt();
        chatMessage = packetData.readUTF8();
    }

    @Override
    public void handle() {

    }
}
