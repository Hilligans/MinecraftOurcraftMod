package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SMapData extends PacketBase {

    public int mapID;
    public byte scale;
    public boolean trackingPosition;
    public boolean locked;
    public int iconCount;
    //TODO finish decoding

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        mapID = packetData.readVarInt();
        scale = packetData.readByte();
        trackingPosition = packetData.readBoolean();
        locked = packetData.readBoolean();
        iconCount = packetData.readVarInt();
    }

    @Override
    public void handle() {

    }
}
