package dev.Hilligans.Networking.Packets.Play.Client;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

public class CSendChatMessage extends PacketBase {

    public String message;

    public CSendChatMessage() {}

    public CSendChatMessage(String message) {
        this.message = message;
    }

    @Override
    public void encode(PacketData packetData) {
        packetData.writeUTF8(message);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
