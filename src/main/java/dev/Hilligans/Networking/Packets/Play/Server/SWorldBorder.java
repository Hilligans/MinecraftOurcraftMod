package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SWorldBorder extends PacketBase {

    public int action;

    //used for action 0,1,3
    public double diameter;

    //used for action 1,3
    public double newDiameter;
    public long speed;

    //used for action 2,3
    public double x;
    public double z;

    //used for action 3
    public int portalTeleportBoundary;

    //used for action 3 and 4
    public int warningTime;

    //used for action 3 and 5
    public int warningBlocks;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        action = packetData.readVarInt();
        if(action == 0) {
            diameter = packetData.readDouble();
        } else if(action == 1) {
            diameter = packetData.readDouble();
            newDiameter = packetData.readDouble();
            speed = packetData.readLong();
        } else if(action == 2) {
            x = packetData.readDouble();
            z = packetData.readDouble();
        } else if(action == 3) {
            x = packetData.readDouble();
            z = packetData.readDouble();
            diameter = packetData.readDouble();
            newDiameter = packetData.readDouble();
            speed = packetData.readVarLong();
            portalTeleportBoundary = packetData.readVarInt();
            warningBlocks = packetData.readVarInt();
            warningTime = packetData.readVarInt();
        } else if(action == 4) {
            warningTime = packetData.readVarInt();
        } else if(action == 5) {
            warningBlocks = packetData.readVarInt();
        }
    }

    @Override
    public void handle() {

    }
}
