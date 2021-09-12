package dev.Hilligans.Util;

import Hilligans.Block.Block;
import Hilligans.Data.Other.BlockProperties;
import Hilligans.ModHandler.Content.ModContent;
import Hilligans.Ourcraft;
import Hilligans.WorldSave.WorldLoader;
import dev.Hilligans.Main;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VersionTable {
    public HashMap<String, ArrayList<Integer>> blockNetworkIDs = new HashMap<>();


    public VersionTable(String path) {
        JSONObject jsonObject = new JSONObject(WorldLoader.readString(path));
        JSONArray jsonArray = jsonObject.getJSONArray("blocks");
        for(int x = 0; x < jsonArray.length(); x++) {
            blockNetworkIDs.computeIfAbsent(jsonArray.getString(x), a -> new ArrayList<>()).add(x);

        }
    }
}
