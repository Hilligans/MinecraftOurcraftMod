package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SRemoveEntityEffect extends PacketBase {

    public int entityID;
    public byte effectID;


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        effectID = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
