package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSoundEffect extends PacketBase {

    public int soundID;
    public int soundCategory;
    public int x;
    public int y;
    public int z;
    public float volume;
    public float pitch;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        soundID = packetData.readVarInt();
        soundCategory = packetData.readVarInt();
        x = packetData.readInt();
        y = packetData.readInt();
        z = packetData.readInt();
        volume = packetData.readFloat();
        pitch = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
