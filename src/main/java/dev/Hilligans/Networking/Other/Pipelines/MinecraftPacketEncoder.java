package dev.Hilligans.Networking.Other.Pipelines;

import Hilligans.Network.PacketData;
import Hilligans.Network.PacketEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class MinecraftPacketEncoder extends PacketEncoder {


    public MinecraftPacketEncoder(int packetWidth, boolean compressed) {
        super(packetWidth, compressed);
    }


    @Override
    protected void encode(ChannelHandlerContext ctx, PacketData msg, ByteBuf out) throws Exception {
        writeVarInt(msg.size + getVarIntSize(msg.packetId),out);
        writeVarInt(msg.packetId,out);
        out.writeBytes(msg.byteBuf);
    }

    public static void writeVarInt(int value, ByteBuf byteBuf) {
        while (true) {
            if ((value & 0xFFFFFF80) == 0) {
                byteBuf.writeByte(value);
                return;
            }
            byteBuf.writeByte(value & 0x7F | 0x80);
            value >>>= 7;
        }
    }

    public static int getVarIntSize(int input) {
        for(int i = 1; i < 5; ++i) {
            if ((input & -1 << i * 7) == 0) {
                return i;
            }
        }
        return 5;
    }
}
