package dev.Hilligans.Networking.Other.Pipelines;

import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Network.PacketDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public class MinecraftPacketDecoder extends PacketDecoder  {
    public MinecraftPacketDecoder(int packetWidth, boolean compressed) {
        super(packetWidth, compressed);
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        this.packetLength = in.readableBytes();
        in.resetReaderIndex();
        in.markReaderIndex();
        try {
            this.dataLength = readVarInt(in);
        } catch (Exception e) {
            in.resetReaderIndex();
            return;
        }
        if (this.packetLength < this.dataLength + MinecraftPacketEncoder.getVarIntSize(dataLength)) {
            in.resetReaderIndex();
            return;
        }

        byte[] bytes = new byte[this.dataLength];
        in.readBytes(bytes);
        PacketData packetData = new PacketData(bytes);
        packetData.packetId = (short) packetData.readVarInt();
        System.out.println("In:" + packetData.packetId);
        packetData.ctx = ctx;
        out.add(packetData);
        in.markReaderIndex();
    }

    public static int readVarInt(ByteBuf byteBuf) throws Exception {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            read = byteBuf.readByte();
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 5) {
                throw new RuntimeException("VarInt is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }
}
