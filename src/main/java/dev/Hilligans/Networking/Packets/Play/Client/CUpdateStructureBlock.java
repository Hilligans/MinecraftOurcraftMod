package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CUpdateStructureBlock extends PacketBase {

    public EightBytePosition location;
    public int action;
    public int mode;
    public String name;
    public byte offsetX;
    public byte offsetY;
    public byte offsetZ;
    public byte sizeX;
    public byte sizeY;
    public byte sizeZ;
    public int mirror;
    public int rotation;
    public String metaData;
    public float integrity;
    public long seed;
    public byte flags;

    public CUpdateStructureBlock(EightBytePosition location, int action, int mode, String name, byte offsetX, byte offsetY, byte offsetZ, byte sizeX, byte sizeY, byte sizeZ, int mirror, int rotation, String metaData, float integrity, long seed, byte flags) {
        this.location = location;
        this.action = action;
        this.mode = mode;
        this.name = name;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.mirror = mirror;
        this.rotation = rotation;
        this.metaData = metaData;
        this.integrity = integrity;
        this.seed = seed;
        this.flags = flags;
    }

    public CUpdateStructureBlock() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeEightBytePosition(location);
        packetData.writeVarInt(action);
        packetData.writeVarInt(mirror);
        packetData.writeUTF8(name);
        packetData.writeByte(offsetX);
        packetData.writeByte(offsetY);
        packetData.writeByte(offsetZ);
        packetData.writeByte(sizeX);
        packetData.writeByte(sizeY);
        packetData.writeByte(sizeZ);
        packetData.writeVarInt(mirror);
        packetData.writeVarInt(rotation);
        packetData.writeUTF8(metaData);
        packetData.writeFloat(integrity);
        packetData.writeVarLong(seed);
        packetData.writeByte(flags);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
