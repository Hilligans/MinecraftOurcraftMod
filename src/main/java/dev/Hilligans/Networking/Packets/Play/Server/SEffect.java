package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEffect extends PacketBase {

    public int effectID;
    public EightBytePosition position;
    public int data;
    public boolean disableRelativeVolume;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        effectID = packetData.readInt();
        position = packetData.readEightBytePosition();
        data = packetData.readInt();
        disableRelativeVolume = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
