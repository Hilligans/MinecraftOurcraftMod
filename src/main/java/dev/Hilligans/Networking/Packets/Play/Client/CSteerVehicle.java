package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CSteerVehicle extends PacketBase {

    public float sideways;
    public float forward;
    public byte flags;

    public CSteerVehicle(float sideways, float forward, byte flags) {
        this.sideways = sideways;
        this.forward = forward;
        this.flags = flags;
    }

    public CSteerVehicle() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeFloat(sideways);
        packetData.writeFloat(forward);
        packetData.writeByte(flags);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
