package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CGenerateStructure extends PacketBase {

    public EightBytePosition position;
    public int levels;
    public boolean keepJigsaws;

    public CGenerateStructure(EightBytePosition position, int levels, boolean keepJigsaws) {
        this.position = position;
        this.levels = levels;
        this.keepJigsaws = keepJigsaws;
    }

    public CGenerateStructure() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeEightBytePosition(position);
        packetData.writeVarInt(levels);
        packetData.writeBoolean(keepJigsaws);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
