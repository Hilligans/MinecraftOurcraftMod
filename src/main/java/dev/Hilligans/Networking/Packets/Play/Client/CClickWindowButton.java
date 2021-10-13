package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CClickWindowButton extends PacketBase {

    public byte windowID;
    public byte buttonID;

    public CClickWindowButton(byte windowID, byte buttonID) {
        this.windowID = windowID;
        this.buttonID = buttonID;
    }

    public CClickWindowButton() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(windowID);
        packetData.writeByte(buttonID);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
