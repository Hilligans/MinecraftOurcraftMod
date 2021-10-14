package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CClickWindow extends PacketBase {

    public byte windowId;
    public short slot;
    public byte button;
    public short actionNumber;
    public int mode;
    public ItemStack slotContent = new ItemStack(null,0);

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(windowId);
        packetData.writeShort(slot);
        packetData.writeByte(button);
        packetData.writeShort(actionNumber);
        packetData.writeVarInt(mode);
        packetData.writeItemStack(slotContent);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
