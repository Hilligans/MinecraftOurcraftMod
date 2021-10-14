package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityPositionAndRotation extends PacketBase {

    public int entityID;
    public short deltaX;
    public short deltaY;
    public short deltaZ;
    public byte yaw;
    public byte pitch;
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
        yaw = packetData.readByte();
        pitch = packetData.readByte();
        onGround = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
