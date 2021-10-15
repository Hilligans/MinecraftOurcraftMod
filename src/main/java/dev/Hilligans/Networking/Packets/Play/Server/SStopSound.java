package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SStopSound extends PacketBase {

    public byte flags;
    public int source;
    public String sound;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        flags = packetData.readByte();
        if((flags & 0x1) != 0) {
            source = packetData.readVarInt();
        }
        if((flags & 0x2) != 0) {
            sound = packetData.readUTF8();
        }
    }

    @Override
    public void handle() {

    }
}
