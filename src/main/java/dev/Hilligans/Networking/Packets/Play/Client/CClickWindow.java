package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.Util.MCSlot;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CClickWindow extends PacketBase {

    public byte windowId;
    public short slot;
    public byte button;
    public short actionNumber;
    public int mode;
    public MCSlot slotContent = new MCSlot();

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(windowId);
        packetData.writeShort(slot);
        packetData.writeByte(button);
        packetData.writeShort(actionNumber);
        packetData.writeVarInt(mode);
        slotContent.put(packetData);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
