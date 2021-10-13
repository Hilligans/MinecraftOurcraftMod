package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CUpdateSign extends PacketBase {

    public EightBytePosition location;
    //384 characters
    public String line1;
    public String line2;
    public String line3;
    public String line4;

    public CUpdateSign(EightBytePosition location, String line1, String line2, String line3, String line4) {
        this.location = location;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
    }

    public CUpdateSign() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeEightBytePosition(location);
        packetData.writeUTF8(line1);
        packetData.writeUTF8(line2);
        packetData.writeUTF8(line3);
        packetData.writeUTF8(line4);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
