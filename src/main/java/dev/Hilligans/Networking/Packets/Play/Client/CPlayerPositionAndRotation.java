package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerPositionAndRotation extends PacketBase {

    public double x;
    public double feetY;
    public double z;
    public float yaw;
    public float pitch;
    public boolean onGround;

    public CPlayerPositionAndRotation(double x, double feetY, double z, float pitch, float yaw, boolean onGround) {
        this.x = x;
        this.feetY = feetY;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.onGround = onGround;
    }

    public CPlayerPositionAndRotation() {}

    @Override
    public void encode(PacketData packetData) {
        packetData.writeDouble(x);
        packetData.writeDouble(feetY);
        packetData.writeDouble(z);
        packetData.writeFloat(yaw);
        packetData.writeFloat(pitch);
        packetData.writeBoolean(onGround);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
