package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityPosition extends PacketBase {

    public int entityID;
    public short deltaX;
    public short deltaY;
    public short deltaZ;
    public boolean onGround;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        deltaX = packetData.readShort();
        deltaY = packetData.readShort();
        deltaZ = packetData.readShort();
        onGround = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
