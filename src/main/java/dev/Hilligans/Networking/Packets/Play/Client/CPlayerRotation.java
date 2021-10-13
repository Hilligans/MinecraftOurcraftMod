package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerRotation extends PacketBase {

    public float yaw;
    public float pitch;
    public boolean onGround;

    public CPlayerRotation(float pitch, float yaw, boolean onGround) {
        this.pitch = pitch;
        this.yaw = yaw;
        this.onGround = onGround;
    }

    public CPlayerRotation() {}

    @Override
    public void encode(PacketData packetData) {
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
