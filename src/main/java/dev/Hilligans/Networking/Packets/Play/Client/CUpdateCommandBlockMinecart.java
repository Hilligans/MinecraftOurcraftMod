package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CUpdateCommandBlockMinecart extends PacketBase {

    public int entityID;
    public String command;
    public boolean trackOutput;

    public CUpdateCommandBlockMinecart(int entityID, String command, boolean trackOutput) {
        this.entityID = entityID;
        this.command = command;
        this.trackOutput = trackOutput;
    }

    public CUpdateCommandBlockMinecart() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(entityID);
        packetData.writeUTF8(command);
        packetData.writeBoolean(trackOutput);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
