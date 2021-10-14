package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Item.ItemStack;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class STradeList extends PacketBase  {

    public int windowID;
    public Trade[] trades;
    public int villagerLevel;
    public int experience;
    public boolean isRegularVillager;
    public boolean canRestock;

    //public byte size;
    //pub

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        windowID = packetData.readVarInt();
        trades = new Trade[packetData.readByte()];
        for(int x = 0; x < trades.length; x++) {
            trades[x] = new Trade(packetData);
        }
        villagerLevel = packetData.readVarInt();
        experience = packetData.readVarInt();
        isRegularVillager = packetData.readBoolean();
        canRestock = packetData.readBoolean();
    }

    @Override
    public void handle() {

    }

    static class Trade {
        public ItemStack slot;
        public ItemStack slot2;
        public ItemStack output;
        public boolean disabled;
        public int tradesUsed;
        public int maxTrades;
        public int xp;
        public int specialPrice;
        public float priceMultiplier;
        public int demand;

        public Trade(PacketData packetData) {
            slot = packetData.readItemStack();
            output = packetData.readItemStack();
            if (packetData.readBoolean()) {
                slot2 = packetData.readItemStack();
            }
            disabled = packetData.readBoolean();
            tradesUsed = packetData.readInt();
            maxTrades = packetData.readInt();
            xp = packetData.readInt();
            specialPrice = packetData.readInt();
            priceMultiplier = packetData.readFloat();
            demand = packetData.readInt();
        }

    }
}
