package dev.Hilligans.Util;

import dev.Hilligans.ourcraft.ClientMain;
import dev.Hilligans.ourcraft.Data.Primitives.Tuplet;
import dev.Hilligans.ourcraft.World.DriveChunk;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ChunkProcessor {

    public static ConcurrentLinkedQueue<DriveChunk> chunks = new ConcurrentLinkedQueue<>();

    public static void process(DriveChunk driveChunk) {
        chunks.add(driveChunk);
    }

    public static void create() {
        ArrayList<DriveChunk> unload = new ArrayList<>();
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                for (DriveChunk chunk : chunks) {
                    if (chunk.time + 20000 < System.currentTimeMillis()) {
                        unload.add(chunk);
                        chunk.unload();
                    }
                }
                chunks.removeAll(unload);
                unload.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },1000,2, TimeUnit.MILLISECONDS);
    }

}
