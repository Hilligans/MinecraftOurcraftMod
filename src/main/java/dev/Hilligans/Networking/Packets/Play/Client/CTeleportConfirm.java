package dev.Hilligans.Networking.Packets.Play.Client;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

public class CTeleportConfirm extends PacketBase {

    int val;

    public CTeleportConfirm() {}

    public CTeleportConfirm(int val) {
        this.val = val;
    }



    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(val);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
