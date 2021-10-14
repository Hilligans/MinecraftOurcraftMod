package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SNamedSoundEffect extends PacketBase {

    public String name;
    public int soundCategory;
    public int effectX;
    public int effectY;
    public int effectZ;
    public float volume;
    public float pitch;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        name = packetData.readUTF8();
        soundCategory = packetData.readVarInt();
        effectX = packetData.readVarInt();
        effectY = packetData.readVarInt();
        effectZ = packetData.readVarInt();
        volume = packetData.readFloat();
        pitch = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
