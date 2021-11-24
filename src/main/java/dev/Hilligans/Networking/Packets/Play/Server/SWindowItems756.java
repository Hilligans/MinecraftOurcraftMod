package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SWindowItems756 extends PacketBase {

    public short windowID;
    public short itemCount;
    public ItemStack[] slots;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readUnsignedByte();
        int stateID = packetData.readVarInt();
        int count = packetData.readVarInt();
        for(int x = 0; x < itemCount; x++) {
            slots[x] = packetData.readItemStack();
        }
        ItemStack heldItem = packetData.readItemStack();
    }

    @Override
    public void handle() {

    }
}
