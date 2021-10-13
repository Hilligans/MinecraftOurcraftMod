package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerDigging extends PacketBase {

    public int status;
    public EightBytePosition position;
    public byte face;

    public CPlayerDigging(int status, EightBytePosition position, byte face) {
        this.status = status;
        this.position = position;
        this.face = face;
    }

    public CPlayerDigging() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(status);
        packetData.writeEightBytePosition(position);
        packetData.writeByte(face);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
