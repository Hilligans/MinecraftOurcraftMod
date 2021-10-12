package dev.Hilligans.Networking.Packets.Play.Client;

import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;

public class CPlayerPosition extends PacketBase {

   double x,y,z;

   public CPlayerPosition() {}

    public CPlayerPosition(double x, double y, double z) {
       this.x = x;
       this.y = y;
       this.z = z;
    }



    @Override
    public void encode(PacketData packetData) {
        packetData.writeDouble(x);
        packetData.writeDouble(y);
        packetData.writeDouble(z);
        packetData.writeBoolean(false);
    }

    @Override
    public void decode(PacketData packetData) {

    }

    @Override
    public void handle() {

    }
}
