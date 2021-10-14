package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

import java.util.Arrays;

public class SWindowItems extends PacketBase {


    //window id of 0 for normal inventory
    public short windowID;
    public short itemCount;
    public ItemStack[] slots;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readUnsignedByte();
        itemCount = packetData.readShort();
        slots = new ItemStack[itemCount];
        for(int x = 0; x < itemCount; x++) {
            slots[x] = packetData.readItemStack();
        }
        System.out.println(Arrays.toString(slots));

    }

    @Override
    public void handle() {
    }
}
