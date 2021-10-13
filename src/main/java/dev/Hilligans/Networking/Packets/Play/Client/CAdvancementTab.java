package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CAdvancementTab extends PacketBase {

    public int action;
    public String identifier;

    public CAdvancementTab(int action, String identifier) {
        this.action = action;
        this.identifier = identifier;
    }

    public CAdvancementTab() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(action);
        if(action == 0) {
            packetData.writeUTF8(identifier);
        }
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
