package dev.Hilligans.Networking.Packets.Play.Server;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;

public class SJoinGame extends PacketBase {


    boolean hardcore;
    byte gamemode;
    int entityId;



    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
