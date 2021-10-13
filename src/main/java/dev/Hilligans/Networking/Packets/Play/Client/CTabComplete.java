package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CTabComplete extends PacketBase {

    public int transactionID;
    public String message;

    public CTabComplete(int transactionID, String message) {
        this.transactionID = transactionID;
        this.message = message;
    }

    public CTabComplete() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(transactionID);
        packetData.writeUTF8(message);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
