package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SOpenHorseWindow extends PacketBase {

    public byte windowID;
    public int slots;
    public int entityID;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readByte();
        slots = packetData.readVarInt();
        entityID = packetData.readInt();
    }

    @Override
    public void handle() {

    }
}
