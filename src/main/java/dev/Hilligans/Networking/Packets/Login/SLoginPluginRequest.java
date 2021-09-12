package dev.Hilligans.Networking.Packets.Login;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;
import dev.Hilligans.Main;

public class SLoginPluginRequest extends PacketBase {
    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        Main.messageID = packetData.readVarInt();
        String id = packetData.readUTF8();
       // System.out.println(id);
    }

    @Override
    public void handle() {

    }
}
