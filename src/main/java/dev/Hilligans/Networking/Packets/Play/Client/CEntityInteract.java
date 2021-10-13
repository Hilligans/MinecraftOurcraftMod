package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CEntityInteract extends PacketBase {

    public int entityID;
    public int actionType;
    public float targetX;
    public float targetY;
    public float targetZ;
    public int hand;
    public boolean sneaking;

    public CEntityInteract(int entityID, int actionType, float targetX, float targetY, float targetZ, int hand, boolean sneaking) {
        this.entityID = entityID;
        this.actionType = actionType;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
        this.hand = hand;
        this.sneaking = sneaking;
    }

    public CEntityInteract() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(entityID);
        packetData.writeVarInt(actionType);
        if(actionType == 1) {
            packetData.writeFloat(targetX);
            packetData.writeFloat(targetY);
            packetData.writeFloat(targetZ);
        } else {
            packetData.writeVarInt(hand);
        }
        packetData.writeBoolean(sneaking);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
