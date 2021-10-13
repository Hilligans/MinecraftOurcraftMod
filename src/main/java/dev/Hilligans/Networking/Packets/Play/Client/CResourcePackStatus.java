package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CResourcePackStatus extends PacketBase {

    public int result;

    public CResourcePackStatus(int result) {
        this.result = result;
    }

    public CResourcePackStatus() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(result);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
