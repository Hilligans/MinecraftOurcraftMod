package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CUpdateCommandBlock extends PacketBase {

    public EightBytePosition position;
    public String command;
    public int mode;
    public byte flags;

    public CUpdateCommandBlock(EightBytePosition position, String command, int mode, byte flags) {
        this.position = position;
        this.command = command;
        this.mode = mode;
        this.flags = flags;
    }

    public CUpdateCommandBlock() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeEightBytePosition(position);
        packetData.writeUTF8(command);
        packetData.writeVarInt(mode);
        packetData.writeByte(flags);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }

}
