package lknq.speedrunhelper.debug;

import net.minecraft.util.math.ChunkPos;

public final class DebugStats {

    public static int chunksScanned = 0;
    public static int interestingBlocks = 0;

    public static long lastScanTimeNs = 0;
    public static long maxScanTimeNs = 0;

    public static ChunkPos lastChunk = null;

    private DebugStats() {
    }

    public static void recordScan(ChunkPos chunk, int interesting, long nanos) {

        chunksScanned++;

        interestingBlocks += interesting;

        lastChunk = chunk;

        lastScanTimeNs = nanos;

        if (nanos > maxScanTimeNs) {
            maxScanTimeNs = nanos;
        }
    }
}