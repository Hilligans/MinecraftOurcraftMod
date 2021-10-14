package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SBlockBreakAnimation extends PacketBase {

    public int entityID;
    public EightBytePosition position;
    public byte destroyStage;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        position = packetData.readEightBytePosition();
        destroyStage = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
