package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

import java.util.UUID;

public class SBossBar extends PacketBase {

    public UUID uuid;
    public int action;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        uuid = UUID.nameUUIDFromBytes(packetData.readBytes(16));
        action = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
