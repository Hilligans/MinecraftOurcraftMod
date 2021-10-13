package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Data.Other.EightBytePosition;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CUpdateJigsawBlock extends PacketBase {

    public EightBytePosition position;
    public String name;
    public String target;
    public String pool;
    public String finalState;
    public String jointType;

    public CUpdateJigsawBlock(EightBytePosition position, String name, String target, String pool, String finalState, String jointType) {
        this.position = position;
        this.name = name;
        this.target = target;
        this.pool = pool;
        this.finalState = finalState;
        this.jointType = jointType;
    }

    public CUpdateJigsawBlock() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeEightBytePosition(position);
        packetData.writeUTF8(name);
        packetData.writeUTF8(target);
        packetData.writeUTF8(pool);
        packetData.writeUTF8(finalState);
        packetData.writeUTF8(jointType);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
