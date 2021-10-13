package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerAbilities extends PacketBase {

    public byte mask = 0;

    public CPlayerAbilities(boolean flying) {
        if(flying) {
            mask = 0x02;
        }
    }

    public CPlayerAbilities() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeByte(mask);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
