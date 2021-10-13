package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.Util.MCSlot;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CEditBook extends PacketBase {

    public MCSlot saveSlot;
    public boolean signing;
    public int hand;

    public CEditBook(boolean signing, int hand) {
        saveSlot = new MCSlot();
        this.signing = signing;
        this.hand = hand;
    }

    public CEditBook() {}

    @Override
    public void encode(PacketData packetData) {
        saveSlot.put(packetData);
        packetData.writeBoolean(signing);
        packetData.writeVarInt(hand);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
