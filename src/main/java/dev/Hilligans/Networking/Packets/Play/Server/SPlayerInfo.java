package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Util.UUID;

public class SPlayerInfo extends PacketBase {

    public int action;
    public int numberOfPlayers;

    public Player[] players;


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        action = packetData.readVarInt();
        numberOfPlayers = packetData.readVarInt();
        players = new Player[numberOfPlayers];
        for(int x = 0; x < numberOfPlayers; x++) {
            players[x] = new Player(action,packetData);
        }
    }

    @Override
    public void handle() {

    }

    static class Player {

        public UUID uuid;

        //values of action 0
        public String name;
        public int propertyCount;
        public Property[] properties;

        //shared by both action 0 and action 1
        public int gamemode;

        //shared by both action 0 and action 2
        public int ping;

        //shared by both action 0 and action 3
        public boolean hasDisplayName;
        public String displayName;



        public Player(int action, PacketData packetData) {
            uuid = new UUID(packetData);
            if(action == 0) {
                name = packetData.readUTF8();
                propertyCount = packetData.readVarInt();
                properties = new Property[propertyCount];
                for(int x = 0; x < propertyCount; x++) {
                    properties[x] = new Property(packetData);
                }
                gamemode = packetData.readVarInt();
                ping = packetData.readVarInt();
                hasDisplayName = packetData.readBoolean();
                if(hasDisplayName) {
                    displayName = packetData.readUTF8();
                }
            } else if(action == 1) {
                gamemode = packetData.readVarInt();
            } else if(action == 2) {
                ping = packetData.readVarInt();
            } else if(action == 3) {
                hasDisplayName = packetData.readBoolean();
                if(hasDisplayName) {
                    displayName = packetData.readUTF8();
                }
            }
        }


    }

    static class Property {
        public String name;
        public String value;
        public boolean isSigned;
        public String signature;

        public Property(PacketData packetData) {
            name = packetData.readUTF8();
            value = packetData.readUTF8();
            isSigned = packetData.readBoolean();
            if(isSigned) {
                signature = packetData.readUTF8();
            }
        }
    }
}
