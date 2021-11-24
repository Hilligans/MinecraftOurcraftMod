package dev.Hilligans.Networking.Other.Pipelines;

import dev.Hilligans.Main;
import dev.Hilligans.ourcraft.Network.PacketData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressedMinecraftPacketDecoder extends MinecraftPacketDecoder {

    Inflater inflater;

    public CompressedMinecraftPacketDecoder(int packetWidth, boolean compressed) {
        super(packetWidth, compressed);
        inflater = new Inflater();
    }

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        this.packetLength = in.readableBytes();
        in.resetReaderIndex();
        in.markReaderIndex();
        int uncompressedLength;
        try {
            this.dataLength = readVarInt(in);
            uncompressedLength = readVarInt(in);
        } catch (Exception e) {
            in.resetReaderIndex();
            return;
        }
        if (this.packetLength < this.dataLength + MinecraftPacketEncoder.getVarIntSize(dataLength)) {
            in.resetReaderIndex();
            return;
        }

        byte[] bytes = new byte[this.dataLength - MinecraftPacketEncoder.getVarIntSize(uncompressedLength)];
        in.readBytes(bytes);

        if(uncompressedLength != 0) {
            inflater.setInput(bytes);
            byte[] newBytes = new byte[uncompressedLength];
            try {
                inflater.inflate(newBytes);
            } catch (Exception e) {
                e.printStackTrace();
                in.resetReaderIndex();
                inflater.reset();
                return;
            }
            inflater.reset();
            PacketData packetData = new PacketData(newBytes);
            packetData.packetId = (short) packetData.readVarInt();
           // System.out.println("In:" + packetData.packetId);
            packetData.ctx = ctx;
            if(Main.debugPackets) {
                System.out.println("S -> C " + packetData.packetId);
            }
            out.add(packetData);
        } else {
            PacketData packetData = new PacketData(bytes);
            packetData.packetId = (short) packetData.readVarInt();
           // System.out.println("In:" + packetData.packetId);
            packetData.ctx = ctx;
            if(Main.debugPackets) {
                System.out.println("S -> C " + packetData.packetId);
            }
            out.add(packetData);
        }
        in.markReaderIndex();
    }



}
