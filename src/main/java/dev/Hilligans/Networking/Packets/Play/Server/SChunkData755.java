package dev.Hilligans.Networking.Packets.Play.Server;

import dev.Hilligans.Util.BlockManager;
import dev.Hilligans.Util.BlockPalette;
import dev.Hilligans.ourcraft.Block.Blocks;
import dev.Hilligans.ourcraft.ClientMain;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Ourcraft;
import dev.Hilligans.ourcraft.Tag.CompoundNBTTag;
import dev.Hilligans.ourcraft.Util.ByteArray;
import dev.Hilligans.ourcraft.World.Chunk;
import io.netty.buffer.Unpooled;

import java.util.BitSet;

public class SChunkData755 extends PacketBase {

    public int chunkX;
    public int chunkZ;

    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        Ourcraft.EXECUTOR.submit(new Runnable() {
            @Override
            public void run() {
                BitSet bitSet;
                chunkX = packetData.readInt();
                chunkZ = packetData.readInt();
                int bitMask = packetData.readVarInt();
                bitSet = BitSet.valueOf(packetData.readLongs(bitMask));
                CompoundNBTTag heightmap = packetData.readCompoundTag();
                    int count = packetData.readVarInt();
                    for(int x = 0; x < count; x++) {
                        packetData.readVarInt();
                    }
                int dataSize = packetData.readVarInt();
                byte[] bytes = packetData.readBytes(dataSize);
                int bitsPer;

                    ByteArray byteArray = new ByteArray(Unpooled.wrappedBuffer(bytes));
                    for (int a = 0; a < 16; a++) {
                        try {
                            if (!bitSet.get(a)) {
                                continue;
                            }
                            byteArray.readShort();
                            bitsPer = byteArray.readByte();
                            BlockPalette blockPalette = new BlockPalette();
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
                                chunk = new Chunk(chunkX, chunkZ, ClientMain.getClient().clientWorld);
                            }
                            for (int x = 0; x < 16; x++) {
                                for (int y = 0; y < 16; y++) {
                                    for (int z = 0; z < 16; z++) {
                                        int id;
                                        id = blockPalette.vals[blocks[y << 8 | z << 4 | x]];
                                        chunk.setBlockState(x, y + a * 16, z, BlockManager.blocks.getOrDefault(id, Blocks.BEDROCK).getStateWithData((short) BlockManager.blockStates.getOrDefault(id,0)));
                                    }
                                }
                            }
                            if(aa) {
                                ClientMain.getClient().clientWorld.setChunk(chunk, chunk.x, chunk.z);
                            }
                        } catch (Exception ignored) {
                            ignored.printStackTrace();
                        }
                    }
               // }
            }
        });

    }

    static int chunkCount = 0;

    @Override
    public void handle() {

    }
}