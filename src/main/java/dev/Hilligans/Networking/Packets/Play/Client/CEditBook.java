package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CEditBook extends PacketBase {

    public ItemStack saveSlot;
    public boolean signing;
    public int hand;

    public CEditBook(boolean signing, int hand) {
        this.saveSlot = new ItemStack(null,0);
        this.signing = signing;
        this.hand = hand;
    }

    public CEditBook() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeItemStack(saveSlot);
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
