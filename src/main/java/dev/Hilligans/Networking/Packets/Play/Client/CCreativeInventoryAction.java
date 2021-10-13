package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.Util.MCSlot;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CCreativeInventoryAction extends PacketBase {

    public short slot;
    public MCSlot clickedItem;

    public CCreativeInventoryAction(short slot, MCSlot clickedItem) {
        this.slot = slot;
        this.clickedItem = clickedItem;
    }

    public CCreativeInventoryAction() {}


    @Override
    public void encode(PacketData packetData) {
        packetData.writeShort(slot);
        clickedItem.put(packetData);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
