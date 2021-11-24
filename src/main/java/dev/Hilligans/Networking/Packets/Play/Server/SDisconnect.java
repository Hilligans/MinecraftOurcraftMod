package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SDisconnect extends PacketBase {

    public String chatMessage;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        chatMessage = packetData.readUTF8();
        System.out.println(chatMessage);
    }

    @Override
    public void handle() {

    }
}
