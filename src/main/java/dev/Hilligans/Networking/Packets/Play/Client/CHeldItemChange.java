package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CHeldItemChange extends PacketBase {

    public short slot;

    public CHeldItemChange(short slot) {
        this.slot = slot;
    }

    public CHeldItemChange() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeShort(slot);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
