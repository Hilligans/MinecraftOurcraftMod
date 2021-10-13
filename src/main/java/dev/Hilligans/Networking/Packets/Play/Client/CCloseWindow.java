package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CCloseWindow extends PacketBase {

    public byte windowID;

    public CCloseWindow(byte windowID) {
        this.windowID = windowID;
    }

    public CCloseWindow() {}


    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(windowID);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
