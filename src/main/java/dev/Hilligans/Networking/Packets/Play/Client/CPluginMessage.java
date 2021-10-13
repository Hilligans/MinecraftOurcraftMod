package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPluginMessage extends PacketBase {

    public String identifier;
    public byte[] data;

    public CPluginMessage(String identifier, byte[] data) {
        this.identifier = identifier;
        this.data = data;
    }

    public CPluginMessage() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeUTF8(identifier);
        packetData.writeVarInt(data.length);
        for(byte val : data) {
            packetData.writeByte(val);
        }
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
