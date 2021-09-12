package dev.Hilligans.Util;

import Hilligans.WorldSave.WorldLoader;
import org.json.JSONObject;

import java.util.HashMap;

public class ProtocolVersion {

    public HashMap<String, Integer> protocol = new HashMap<>();

    public ProtocolVersion(String path) {
        JSONObject jsonObject = new JSONObject(WorldLoader.readString(path));
        for(String string : jsonObject.keySet()) {
            protocol.put(string,jsonObject.getInt(string));
        }
    }




}
