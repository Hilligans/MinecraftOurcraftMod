package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Client.ChatWindow;
import dev.Hilligans.ourcraft.ClientMain;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.UUID;

public class SSendChatMessage extends PacketBase {

    public String data;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        data = getChatMessage(packetData.readUTF8());


        System.out.println(data);

    }

    public String getChatMessage(String message) {
        JSONObject jsonObject = new JSONObject(message);
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("extra");
            StringBuilder s = new StringBuilder(jsonObject.getString("text"));
            add(jsonArray,s);
            return s.toString().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public static void add(JSONArray jsonArray, StringBuilder stringBuilder) {
        for (int x = 0; x < jsonArray.length(); x++) {
            JSONObject jsonObject = jsonArray.getJSONObject(x);
            String val = jsonObject.optString("text");
            JSONArray array = jsonObject.optJSONArray("extra");
            if(val != null) {
                stringBuilder.append(val);
            }
            if(array != null) {
                add(array,stringBuilder);
            }
        }
    }

    @Override
    public void handle() {
        ChatWindow.addMessage(data);
    }
}
