package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Tag.CompoundTag;

import java.util.Arrays;

public class SJoinGame extends PacketBase {

    public int entityID;
    public boolean hardcore;
    public short gamemode;
    public byte previousGamemode;
    public int worldCount;
    public String[] worlds;
    public CompoundTag dimensionCodec;
    public CompoundTag dimension;
    public String worldName;
    public long hashedSeed;
    public int maxPlayers;
    public int viewDistance;
    public boolean reducedDebugInfo;
    public boolean isDebug;
    public boolean isFlat;




    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        entityID = packetData.readInt();
        hardcore = packetData.readBoolean();
        gamemode = packetData.readUnsignedByte();
        previousGamemode = packetData.readByte();
        worldCount = packetData.readVarInt();
        worlds = new String[worldCount];
        for(int x = 0; x < worldCount; x++) {
            worlds[x] = packetData.readUTF8();
        }
        dimensionCodec = packetData.readCompoundTag();
        dimension = packetData.readCompoundTag();
        worldName = packetData.readUTF8();
        hashedSeed = packetData.readLong();
        maxPlayers = packetData.readVarInt();
        viewDistance = packetData.readVarInt();
        reducedDebugInfo = packetData.readBoolean();
        isDebug = packetData.readBoolean();
        isFlat = packetData.readBoolean();

    }

    @Override
    public void handle() {

    }
}
