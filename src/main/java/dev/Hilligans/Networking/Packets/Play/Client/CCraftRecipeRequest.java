package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CCraftRecipeRequest extends PacketBase {

    public byte windowID;
    public String identifier;
    public boolean makeAll;

    public CCraftRecipeRequest(byte windowID, String identifier, boolean makeAll) {
        this.windowID = windowID;
        this.identifier = identifier;
        this.makeAll = makeAll;
    }

    public CCraftRecipeRequest() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(windowID);
        packetData.writeUTF8(identifier);
        packetData.writeBoolean(makeAll);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
