package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSetCooldown extends PacketBase {

    public int itemID;
    public int cooldown;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        itemID = packetData.readVarInt();
        cooldown = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
