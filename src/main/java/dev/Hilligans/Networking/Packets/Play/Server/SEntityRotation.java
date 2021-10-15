package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityRotation extends PacketBase  {

    public int entityID;
    public byte yaw;
    public byte pitch;
    public boolean onGround;


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readVarInt();
        yaw = packetData.readByte();
        pitch = packetData.readByte();
        onGround = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
