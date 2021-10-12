package dev.Hilligans.Networking.Other.Pipelines;

import dev.Hilligans.ourcraft.Network.PacketData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.nio.ByteBuffer;
import java.util.zip.Deflater;

public class CompressedMinecraftPacketEncoder extends MinecraftPacketEncoder {
    public CompressedMinecraftPacketEncoder(int packetWidth, boolean compressed) {
        super(packetWidth, compressed);
    }


    @Override
    protected void encode(ChannelHandlerContext ctx, PacketData msg, ByteBuf out) throws Exception {

        if(msg.size + getVarIntSize(msg.packetId) > 256) {
            try {
                Deflater deflater = new Deflater();

                ByteBuf byteBuf = Unpooled.buffer();
                MinecraftPacketEncoder.writeVarInt(msg.packetId, byteBuf);
                byteBuf.writeBytes(msg.byteBuf);

                deflater.setInput(byteBuf.array());
                deflater.finish();

                ByteBuffer buffer = ByteBuffer.allocate(1);
                int size = deflater.deflate(buffer);

                writeVarInt(size,out);
                writeVarInt(msg.size + MinecraftPacketEncoder.getVarIntSize(msg.packetId),out);
                out.writeBytes(buffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            writeVarInt(msg.size + getVarIntSize(msg.packetId) + 1, out);
            writeVarInt(0,out);
            writeVarInt(msg.packetId, out);
            out.writeBytes(msg.byteBuf);
        }




        //out.writeBytes(msg.byteBuf);
    }
}
