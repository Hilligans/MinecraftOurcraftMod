package dev.Hilligans.Util;

import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Tag.CompoundTag;

public class MCSlot {

    public boolean present = false;
    public int itemID;
    public byte itemCount;
    public CompoundTag nbt;

    public MCSlot() {

    }

    public void put(PacketData packetData) {
        packetData.writeBoolean(present);
        if(present) {
            packetData.writeVarInt(itemID);
            packetData.writeByte(itemCount);
            packetData.writeCompoundTag(nbt);
        }
    }


}
