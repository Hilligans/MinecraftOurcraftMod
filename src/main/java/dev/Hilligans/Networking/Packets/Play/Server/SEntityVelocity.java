package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityVelocity extends PacketBase {

    //Velocity is believed to be in units of 1/8000 of a block per server tick (50ms); for example, -1343 would move (-1343 / 8000) = −0.167875 blocks per tick (or −3,3575 blocks per second).
    public int entityID;
    public short velX;
    public short velY;
    public short velZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        velX = packetData.readShort();
        velY = packetData.readShort();
        velZ = packetData.readShort();
    }

    @Override
    public void handle() {

    }
}
