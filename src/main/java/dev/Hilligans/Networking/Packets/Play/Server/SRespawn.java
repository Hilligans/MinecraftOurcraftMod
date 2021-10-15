package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Tag.CompoundTag;

public class SRespawn extends PacketBase {

    public CompoundTag dimension;
    public String worldName;
    public long hashedSeed;
    public short gamemode;
    public short previousGamemode;
    public boolean isDebug;
    public boolean isFlat;
    public boolean copyMetadata;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        dimension = packetData.readCompoundTag();
        worldName = packetData.readUTF8();
        hashedSeed = packetData.readLong();
        gamemode = packetData.readUnsignedByte();
        previousGamemode = packetData.readUnsignedByte();
        isDebug = packetData.readBoolean();
        isFlat = packetData.readBoolean();
        copyMetadata = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
