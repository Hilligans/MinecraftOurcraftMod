package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Client.Camera;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.Main;
import dev.Hilligans.Networking.Packets.Play.Client.CTeleportConfirm;

public class SPlayerPositionAndLookPacket extends PacketBase {

    double x,y,z;
    float pitch,yaw;


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        x = packetData.readDouble();
        y = packetData.readDouble();
        z = packetData.readDouble();
        packetData.readFloat();
        packetData.readFloat();
        packetData.readByte();
        Main.network.sendPacket(new CTeleportConfirm(packetData.readVarInt()));
    }

    @Override
    public void handle() {
        Camera.pos.set(x,y,z);
    }
}
