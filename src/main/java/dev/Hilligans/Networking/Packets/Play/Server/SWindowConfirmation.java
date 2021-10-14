package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SWindowConfirmation extends PacketBase {

    public byte windowID;
    public short actionNumber;
    public boolean accepted;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readByte();
        actionNumber = packetData.readShort();
        accepted = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }
}
