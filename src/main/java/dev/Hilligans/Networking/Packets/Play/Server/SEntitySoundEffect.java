package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntitySoundEffect extends PacketBase {

    public int soundID;
    public int soundCategory;
    public int entityID;
    public float volume;
    public float pitch;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        soundID = packetData.readVarInt();
        soundCategory = packetData.readVarInt();
        entityID = packetData.readVarInt();
        volume = packetData.readFloat();
        pitch = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
