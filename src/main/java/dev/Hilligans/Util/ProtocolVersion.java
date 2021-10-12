package dev.Hilligans.Util;

import dev.Hilligans.ourcraft.WorldSave.WorldLoader;
import dev.Hilligans.Main;
import org.json.JSONObject;

import java.util.HashMap;

public class ProtocolVersion {

    public HashMap<String, Integer> protocol = new HashMap<>();

    public ProtocolVersion(String path) {
        JSONObject jsonObject = new JSONObject(Main.readString(path));
        for(String string : jsonObject.keySet()) {
            protocol.put(string,jsonObject.getInt(string));
        }
    }




}
