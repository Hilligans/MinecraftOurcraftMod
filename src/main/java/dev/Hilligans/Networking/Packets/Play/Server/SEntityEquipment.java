package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SEntityEquipment extends PacketBase {


    //TODO
    public int entityID;
    public ItemStack[] items;
    public byte[] slots;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
