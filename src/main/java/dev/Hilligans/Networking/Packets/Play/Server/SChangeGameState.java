package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SChangeGameState extends PacketBase {

    public short reason;
    public float value;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        reason = packetData.readUnsignedByte();
        value = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
