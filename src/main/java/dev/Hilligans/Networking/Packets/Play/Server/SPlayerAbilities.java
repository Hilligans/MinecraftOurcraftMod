package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SPlayerAbilities extends PacketBase {

    public byte flags;
    public float flyingSpeed;
    public float fovModifier;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        flags = packetData.readByte();
        flyingSpeed = packetData.readFloat();
        fovModifier = packetData.readFloat();
    }

    @Override
    public void handle() {

    }
}
