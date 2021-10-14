package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Tag.CompoundTag;

public class SBlockEntityData extends PacketBase {

    public EightBytePosition position;
    public byte action;
    public CompoundTag tag;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        position = packetData.readEightBytePosition();
        action = packetData.readByte();
        tag = packetData.readCompoundTag();
    }

    @Override
    public void handle() {

    }
}
