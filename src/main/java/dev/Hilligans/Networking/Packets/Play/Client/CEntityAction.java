package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CEntityAction extends PacketBase {

    public int entityID;
    public int actionID;
    public int jumpBoost;

    public CEntityAction(int entityID, int actionID, int jumpBoost) {
        this.entityID = entityID;
        this.actionID = actionID;
        this.jumpBoost = jumpBoost;
    }

    public CEntityAction() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(entityID);
        packetData.writeVarInt(actionID);
        packetData.writeVarInt(jumpBoost);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
