package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SFacePlayer extends PacketBase {

    public int feetEyes;
    public double x;
    public double y;
    public double z;
    public boolean isEntity;
    public int entityID;
    public int entityFeetEyes;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        feetEyes = packetData.readVarInt();
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        isEntity = packetData.readBoolean();
        if(isEntity) {
            entityID = packetData.readVarInt();
            entityFeetEyes = packetData.readVarInt();
        }
    }

    @Override
    public void handle() {

    }
}
