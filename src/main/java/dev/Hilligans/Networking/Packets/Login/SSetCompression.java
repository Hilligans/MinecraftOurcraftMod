package dev.Hilligans.Networking.Packets.Login;

import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;
import dev.Hilligans.Main;
import dev.Hilligans.Networking.Other.Pipelines.CompressedMinecraftPacketDecoder;
import dev.Hilligans.Networking.Other.Pipelines.CompressedMinecraftPacketEncoder;

public class SSetCompression extends PacketBase {


    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        Main.network.channelPipeline.replace("decoder","decoder",new CompressedMinecraftPacketDecoder(2,false));
        Main.network.channelPipeline.replace("encoder","encoder",new CompressedMinecraftPacketEncoder(2,false));
    }

    @Override
    public void handle() {

    }
}
