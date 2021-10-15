package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityEffect extends PacketBase {

    public int entityID;
    public byte effectID;
    public byte amplifier;
    public int duration;
    public byte flags;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        effectID = packetData.readByte();
        amplifier = packetData.readByte();
        duration = packetData.readVarInt();
        flags = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
