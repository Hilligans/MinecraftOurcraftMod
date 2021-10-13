package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSetRecipeBookState extends PacketBase {

    public int bookID;
    public boolean bookOpen;
    public boolean filterActive;

    public CSetRecipeBookState(int bookID, boolean bookOpen, boolean filterActive) {
        this.bookID = bookID;
        this.bookOpen = bookOpen;
        this.filterActive = filterActive;
    }

    public CSetRecipeBookState() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeVarInt(bookID);
        packetData.writeBoolean(bookOpen);
        packetData.writeBoolean(filterActive);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
