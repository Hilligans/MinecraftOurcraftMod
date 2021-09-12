package dev.Hilligans.Util;

import Hilligans.WorldSave.WorldLoader;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util {

    public static JSONObject parseVersionFile(String path) {
        JSONObject blockObject = new JSONObject();
        JSONArray blocks = new JSONArray();
        blockObject.put("blocks",blocks);
        JSONObject jsonObject = new JSONObject(WorldLoader.readString(path));
        for (String s : jsonObject.keySet()) {
            String blockName = s.split(":")[1];
            JSONObject jsonObject1 = jsonObject.getJSONObject(s);
            JSONArray jsonArray = jsonObject1.getJSONArray("states");
            for (int x = 0; x < jsonArray.length(); x++) {
                JSONObject state = jsonArray.getJSONObject(x);
                blocks.put(state.getInt("id"),blockName);
            }
        }
        return blockObject;
    }

    public static JSONObject parseGeneratedBlockFile(String path) {
        JSONObject blockObject = new JSONObject();
        JSONObject jsonObject = new JSONObject(WorldLoader.readString(path));
        for (String s : jsonObject.keySet()) {
            String blockName = s.split(":")[1];
            String a = WorldLoader.readString("/minecraft/blockstates/" + blockName + ".json");
            if(!a.equals("")) {
                JSONObject blockState = new JSONObject(a);
                if (blockState.optJSONObject("variants") != null && blockState.optJSONObject("variants").optJSONObject("") != null) {
                    String val = WorldLoader.readString("/minecraft/models/" + blockState.getJSONObject("variants").getJSONObject("").getString("model").split(":")[1] + ".json");
                    if(!val.equals("")) {
                        JSONObject val1 = new JSONObject(val);
                        if("minecraft:block/cube_all".equals(val1.optString("parent"))) {
                            JSONObject block = new JSONObject();
                            JSONArray jsonArray = new JSONArray();
                            block.put("textures", jsonArray);
                            jsonArray.put(0, blockName + ".png");
                            blockObject.put(blockName, block);
                        }
                    }
                }
            }
        }
        return blockObject;
    }

    public static void printContaining(String path, String string) {
        JSONObject jsonObject = new JSONObject(WorldLoader.readString(path));
        for (String s : jsonObject.keySet()) {
            String blockName = s.split(":")[1];
            if(blockName.contains(string)) {
                System.out.println(blockName);
            }
        }
    }

}
