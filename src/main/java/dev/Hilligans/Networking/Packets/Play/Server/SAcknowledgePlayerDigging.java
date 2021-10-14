package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SAcknowledgePlayerDigging extends PacketBase {

    public EightBytePosition position;
    public int block;
    public int status;
    public boolean successful;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        position = packetData.readEightBytePosition();
        block = packetData.readVarInt();
        status = packetData.readVarInt();
        successful = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
