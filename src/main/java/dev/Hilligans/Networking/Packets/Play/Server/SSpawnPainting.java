package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Util.UUID;

public class SSpawnPainting extends PacketBase {

    public int id;
    public UUID uuid;
    public int paintingType;
    public EightBytePosition position;
    public byte direction;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        id = packetData.readVarInt();
        uuid = new UUID(packetData);
        paintingType = packetData.readVarInt();
        position = packetData.readEightBytePosition();
        direction = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
