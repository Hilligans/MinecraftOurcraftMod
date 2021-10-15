package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SScoreboardObjective extends PacketBase {

    public String name;
    public byte mode;
    public String chat;
    public int type;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        name = packetData.readUTF8();
        mode = packetData.readByte();
        if(mode == 0 || mode == 2) {
            chat = packetData.readUTF8();
            type = packetData.readVarInt();
        }
    }

    @Override
    public void handle() {

    }
}
