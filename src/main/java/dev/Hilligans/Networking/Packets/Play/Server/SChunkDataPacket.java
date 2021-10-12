package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.ourcraft.Block.Blocks;
import dev.Hilligans.ourcraft.ClientMain;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Tag.CompoundTag;
import dev.Hilligans.ourcraft.Util.ByteArray;
import dev.Hilligans.ourcraft.World.Chunk;
import dev.Hilligans.ourcraft.World.DriveChunk;
import dev.Hilligans.ourcraft.World.World;
import dev.Hilligans.ourcraft.WorldSave.ChunkLoader;
import dev.Hilligans.Main;
import dev.Hilligans.Util.BlockManager;
import dev.Hilligans.Util.BlockPalette;
import dev.Hilligans.Util.ChunkProcessor;
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
                    boolean aa = false;
                    if (chunk == null) {
                        aa = true;
                        if(chunkCount < Main.maxChunks) {
                            chunkCount++;
                            chunk = new Chunk(chunkX, chunkZ, ClientMain.getClient().clientWorld);
                        } else {
                            chunk = new DriveChunk(chunkX, chunkZ,ClientMain.getClient().clientWorld, ChunkProcessor::process);
                        }
                    }
                    for (x = 0; x < 16; x++) {
                        for (int y = 0; y < 16; y++) {
                            for (int z = 0; z < 16; z++) {
                                int id;
                                if (blockPalette == null) {
                                    id = blocks[y << 8 | z << 4 | x];
                                } else {
                                    id = blockPalette.vals[blocks[y << 8 | z << 4 | x]];
                                }
                                chunk.setBlockState(x, y + a * 16, z, BlockManager.blocks.getOrDefault(id, Blocks.BEDROCK).getStateWithData((short) BlockManager.blockStates.getOrDefault(id,0)));
                            }
                        }
                    }
                    ChunkLoader.readWriteChunk(chunk);
                    if(aa) {
                        ClientMain.getClient().clientWorld.setChunk(chunk, chunk.x, chunk.z);
                    }
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }


    }

    static int chunkCount = 0;

    @Override
    public void handle() {

    }
}
