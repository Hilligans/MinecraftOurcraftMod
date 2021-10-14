package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import org.bouncycastle.util.Pack;

public class SEntityStatus extends PacketBase {

    public int entityID;
    public byte entityStatus;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readInt();
        entityStatus = packetData.readByte();
    }

    @Override
    public void handle() {

    }
}
