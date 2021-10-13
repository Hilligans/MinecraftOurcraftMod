package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerBlockPlacement extends PacketBase {

    public int hand;
    public EightBytePosition location;
    public int face;
    public float cursorX;
    public float cursorY;
    public float cursorZ;
    public boolean insideBlock;

    public CPlayerBlockPlacement(int hand, EightBytePosition location, int face, float cursorX, float cursorY, float cursorZ, boolean insideBlock) {
        this.hand = hand;
        this.location = location;
        this.face = face;
        this.cursorX = cursorX;
        this.cursorY = cursorY;
        this.cursorZ = cursorZ;
        this.insideBlock = insideBlock;
    }

    public CPlayerBlockPlacement() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(hand);
        packetData.writeEightBytePosition(location);
        packetData.writeVarInt(face);
        packetData.writeFloat(cursorX);
        packetData.writeFloat(cursorY);
        packetData.writeFloat(cursorZ);
        packetData.writeBoolean(insideBlock);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
