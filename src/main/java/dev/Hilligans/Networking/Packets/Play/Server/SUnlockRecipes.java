package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class SUnlockRecipes extends PacketBase {

    public int action;
    public boolean craftingRecipeBookOpen;
    public boolean craftingRecipeBookFilterActive;
    public boolean smeltingRecipeBookOpen;
    public boolean smeltingRecipeBookFilterActive;
    public boolean blastFurnaceRecipeBookOpen;
    public boolean blastFurnaceRecipeBookFilterActive;
    public boolean smokerRecipeBookOpen;
    public boolean smokerRecipeBookFilterActive;
    public int recipeLength;
    public String[] recipeIDs;
    public int secondRecipeLength;
    public String[] secondRecipeIDs;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        action = packetData.readVarInt();
        craftingRecipeBookOpen = packetData.readBoolean();
        craftingRecipeBookFilterActive = packetData.readBoolean();
        smeltingRecipeBookOpen = packetData.readBoolean();
        smeltingRecipeBookFilterActive = packetData.readBoolean();
        blastFurnaceRecipeBookOpen = packetData.readBoolean();
        blastFurnaceRecipeBookFilterActive = packetData.readBoolean();
        smokerRecipeBookOpen = packetData.readBoolean();
        smokerRecipeBookFilterActive = packetData.readBoolean();
        recipeLength = packetData.readVarInt();
        recipeIDs = new String[recipeLength];
        for(int x = 0; x < recipeLength; x++) {
            recipeIDs[x] = packetData.readUTF8();
        }
        if(action == 0) {
            secondRecipeLength = packetData.readVarInt();
            secondRecipeIDs = new String[secondRecipeLength];
            for(int x = 0; x < secondRecipeLength; x++) {
                secondRecipeIDs[x] = packetData.readUTF8();
            }
        }
    }

    @Override
    public void handle() {

    }
}
