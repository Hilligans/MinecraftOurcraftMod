package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SWindowProperty extends PacketBase {

    public short windowID;
    public short property;
    public short value;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readUnsignedByte();
        property = packetData.readShort();
        value = packetData.readShort();
    }

    @Override
    public void handle() {

    }
}
