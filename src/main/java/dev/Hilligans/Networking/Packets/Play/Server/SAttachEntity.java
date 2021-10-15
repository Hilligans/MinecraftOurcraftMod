package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SAttachEntity extends PacketBase {

    public int attachedEntityID;
    public int holdingEntityID;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        attachedEntityID = packetData.readInt();
        holdingEntityID = packetData.readInt();
    }

    @Override
    public void handle() {

    }
}
