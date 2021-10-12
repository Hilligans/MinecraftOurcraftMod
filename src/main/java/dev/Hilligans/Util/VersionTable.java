package dev.Hilligans.Util;

import dev.Hilligans.ourcraft.Block.Block;
import dev.Hilligans.ourcraft.Data.Other.BlockProperties;
import dev.Hilligans.ourcraft.ModHandler.Content.ModContent;
import dev.Hilligans.ourcraft.Ourcraft;
import dev.Hilligans.ourcraft.WorldSave.WorldLoader;
import dev.Hilligans.Main;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VersionTable {
    public HashMap<String, ArrayList<Integer>> blockNetworkIDs = new HashMap<>();


    public VersionTable(String path) {
        JSONObject jsonObject = new JSONObject(Main.readString(path));
        JSONArray jsonArray = jsonObject.getJSONArray("blocks");
        for(int x = 0; x < jsonArray.length(); x++) {
            blockNetworkIDs.computeIfAbsent(jsonArray.getString(x), a -> new ArrayList<>()).add(x);

        }
    }
}
