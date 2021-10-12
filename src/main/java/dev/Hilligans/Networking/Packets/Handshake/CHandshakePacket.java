package dev.Hilligans.Networking.Packets.Handshake;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.Main;

public class CHandshakePacket extends PacketBase {

    public String ip;
    public int port;
    public int nextState;


    public CHandshakePacket(String ip, int port, int nextState) {
        this.ip = ip;
        this.port = port;
        this.nextState = nextState;
    }

    public CHandshakePacket() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(Main.version);
        packetData.writeUTF8(ip);
        packetData.writeShort((short) port);
        packetData.writeVarInt(nextState);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
