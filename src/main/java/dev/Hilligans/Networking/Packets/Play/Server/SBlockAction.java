package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SBlockAction extends PacketBase {

    public EightBytePosition position;
    public short actionID;
    public short actionParam;
    public int blockType;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        position = packetData.readEightBytePosition();
        actionID = packetData.readUnsignedByte();
        actionParam = packetData.readUnsignedByte();
        blockType = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
