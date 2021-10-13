package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CWindowConfirmation extends PacketBase {

    public byte windowID;
    public short actionNumber;
    public boolean accepted;

    public CWindowConfirmation(byte windowID, short actionNumber, boolean accepted) {
        this.windowID = windowID;
        this.actionNumber = actionNumber;
        this.accepted = accepted;
    }

    public CWindowConfirmation() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(windowID);
        packetData.writeShort(actionNumber);
        packetData.writeBoolean(accepted);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
