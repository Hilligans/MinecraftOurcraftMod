package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SSetSlot extends PacketBase {

    public short windowID;
    public short slot;
    public ItemStack slotValue;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readUnsignedByte();
        slot = packetData.readShort();
        slotValue = packetData.readItemStack();
    }

    @Override
    public void handle() {

    }
}
