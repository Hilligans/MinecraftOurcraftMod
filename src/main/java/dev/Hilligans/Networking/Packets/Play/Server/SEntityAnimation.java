package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityAnimation extends PacketBase {

    public int entityID;
    public byte animationID;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        animationID = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
