package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SUpdateScore extends PacketBase {

    public String name;
    public byte action;
    public String objectiveName;
    public int value;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        name = packetData.readUTF8();
        action = packetData.readByte();
        objectiveName = packetData.readUTF8();
        if(action != 1) {
            value = packetData.readVarInt();
        }
    }

    @Override
    public void handle() {

    }
}
