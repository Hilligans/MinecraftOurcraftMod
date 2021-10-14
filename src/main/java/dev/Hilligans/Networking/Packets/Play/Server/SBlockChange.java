package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SBlockChange extends PacketBase {

    public EightBytePosition position;
    public int blockID;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        position = packetData.readEightBytePosition();
        blockID = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
