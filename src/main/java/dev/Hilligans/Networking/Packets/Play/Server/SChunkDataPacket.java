package dev.Hilligans.Networking.Packets.Play.Server;

import Hilligans.Block.Blocks;
import Hilligans.ClientMain;
import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;
import Hilligans.Tag.CompoundTag;
import Hilligans.Util.ByteArray;
import Hilligans.World.Chunk;
import dev.Hilligans.Util.BlockManager;
import dev.Hilligans.Util.BlockPalette;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.BitSet;

public class SChunkDataPacket extends PacketBase {

    public int chunkX;
    public int chunkZ;
    public boolean fullChunk;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        chunkX = packetData.readInt();
        chunkZ = packetData.readInt();
        fullChunk = packetData.readBoolean();
        int bitMask = packetData.readVarInt();
        int index = packetData.byteBuf.readerIndex();
        CompoundTag heightmap = packetData.readCompoundTag();
        if(fullChunk) {
            int count = packetData.readVarInt();
            for(int x = 0; x < count; x++) {
                packetData.readVarInt();
            }
        }
        int dataSize = packetData.readVarInt();
        byte[] bytes = packetData.readBytes(dataSize);
        int bitsPer = 0;
        if(fullChunk) {
            ByteArray byteArray = new ByteArray(Unpooled.wrappedBuffer(bytes));
            for (int a = 0; a < 16; a++) {
                try {
                    if ((bitMask & (1 << a)) == 0) {
                        continue;
                    }
                    byteArray.readShort();
                    bitsPer = byteArray.readByte();
                    BlockPalette blockPalette = null;
                    blockPalette = new BlockPalette();
                    blockPalette.read(byteArray);
                    if (bitsPer > 8) {
                        bitsPer = 15;
                    }
                    if (bitsPer < 4) {
                        bitsPer = 4;
                    }
                    long[] blockData = new long[byteArray.readVarInt()];
                    for (int x = 0; x < blockData.length; x++) {
                        blockData[x] = byteArray.readLong();
                    }
                    int x = 0;
                    int[] blocks = new int[16 * 16 * 16];

                    int longIndex = 0;
                    int bitPointer = 0;
                    for (int i = 0; i < blocks.length; i++) {
                        int val = 0;
                        if (bitPointer + bitsPer > 64) {
                            bitPointer = 0;
                            longIndex++;
                        }
                        for (int c = 0; c < bitsPer; c++) {
                            val |= ((blockData[longIndex] & (1L << (bitPointer + c))) == 0 ? 0 : 1) << c;
                        }
                        bitPointer += bitsPer;
                        blocks[i] = val;
                    }
                    Chunk chunk = ClientMain.getClient().clientWorld.getChunk(chunkX, chunkZ);
                    if (chunk == null) {
                        chunk = new Chunk(chunkX, chunkZ, ClientMain.getClient().clientWorld);
                        ClientMain.getClient().clientWorld.setChunk(chunk);
                    }

                    for (x = 0; x < 16; x++) {
                        for (int y = 0; y < 16; y++) {
                            for (int z = 0; z < 16; z++) {
                                if (blockPalette == null) {
                                    chunk.setBlockState(x, y + a * 16, z, BlockManager.blocks.getOrDefault(blocks[y << 8 | z << 4 | x], Blocks.BEDROCK).getDefaultState());
                                } else {
                                    chunk.setBlockState(x, y + a * 16, z, BlockManager.blocks.getOrDefault(blockPalette.vals[blocks[y << 8 | z << 4 | x]], Blocks.BEDROCK).getDefaultState());
                                }
                            }
                        }
                    }
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }


    }

    @Override
    public void handle() {

    }
}
