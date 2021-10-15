package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Item.Item;
import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CCreativeInventoryAction extends PacketBase {

    public short slot;
    public ItemStack clickedItem;

    public CCreativeInventoryAction(short slot, ItemStack clickedItem) {
        this.slot = slot;
        this.clickedItem = clickedItem;
    }

    public CCreativeInventoryAction() {}


    @Override
    public void encode(PacketData packetData) {
        packetData.writeShort(slot);
        packetData.writeItemStack(clickedItem);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
