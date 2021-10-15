package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SCombatEvent extends PacketBase {

    public int event;
    public int entityID;

    public int duration;

    public int playerID;
    public String deathMessage;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        event = packetData.readVarInt();
        if(event == 1) {
            duration = packetData.readVarInt();
            entityID = packetData.readInt();
        } else if(event == 2) {
            playerID = packetData.readVarInt();
            entityID = packetData.readInt();
            deathMessage = packetData.readUTF8();
        }
    }

    @Override
    public void handle() {

    }
}
