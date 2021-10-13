package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CQueryBlockNBT extends PacketBase {

    public int transactionID;
    public EightBytePosition position;

    public CQueryBlockNBT(int x, int y, int z, int transactionID) {
        this.transactionID = transactionID;
        position = new EightBytePosition(x,y,z);
    }

    public CQueryBlockNBT() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(transactionID);
        packetData.writeEightBytePosition(position);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
