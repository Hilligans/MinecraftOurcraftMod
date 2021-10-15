package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SUpdateHealth extends PacketBase {

    public float health;
    public int food;
    public float saturation;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        health = packetData.readFloat();
        food = packetData.readVarInt();
        saturation = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
