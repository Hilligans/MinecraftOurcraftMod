package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Tag.CompoundTag;

public class SNBTQueryResponse extends PacketBase {

    public int transactionID;
    public CompoundTag tag;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        transactionID = packetData.readVarInt();
        tag = packetData.readCompoundTag();
    }

    @Override
    public void handle() {

    }
}
