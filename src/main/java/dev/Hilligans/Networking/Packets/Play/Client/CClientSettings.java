package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CClientSettings extends PacketBase {

    public String locale;
    public byte renderDistance;
    public int chatMode;
    public boolean chatColors;
    public byte skinParts;
    public int mainHand;

    public CClientSettings(String locale, byte renderDistance, int chatMode, boolean chatColors, byte skinParts, int mainHand) {
        this.locale = locale;
        this.renderDistance = renderDistance;
        this.chatMode = chatMode;
        this.chatColors = chatColors;
        this.skinParts = skinParts;
        this.mainHand = mainHand;
    }

    public CClientSettings() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeUTF8(locale);
        packetData.writeByte(renderDistance);
        packetData.writeVarInt(chatMode);
        packetData.writeBoolean(chatColors);
        packetData.writeByte(skinParts);
        packetData.writeVarInt(mainHand);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
