package dev.Hilligans.Util;

import dev.Hilligans.ourcraft.Util.ByteArray;

import java.util.Arrays;

public class BlockPalette {

    public BlockPalette() {

    }

    public int[] vals = new int[0];

    public void read(ByteArray byteArray) {
        int size = byteArray.readVarInt();
        vals = new int[size];
        for(int x = 0; x < size; x++) {
            vals[x] = byteArray.readVarInt();
        }
     //   System.out.println(Arrays.toString(vals));
    }


}
