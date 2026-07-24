package lknq.speedrunhelper.debug;

import net.minecraft.util.math.ChunkPos;
import lknq.speedrunhelper.debug.DebugStats;

public final class DebugStats {

    public static int chunksScanned = 0;
    public static int interestingBlocks = 0;
    public static int lastVillageScore = 0;
    public static long lastScanNs = 0;
    public static long totalScanNs = 0;

    public static int villageCandidates = 0;
    public static int waypointCount = 0;

    private DebugStats() {}

    public static void recordScan(ChunkPos chunk, int blockCount, long scanTimeNs) {

        chunksScanned++;
        interestingBlocks += blockCount;

        lastScanNs = scanTimeNs;
        totalScanNs += scanTimeNs;
    }

    public static double getLastScanMs() {
        return lastScanNs / 1_000_000.0;
    }

    public static double getAverageScanMs() {

        if (chunksScanned == 0)
            return 0;

        return (totalScanNs / (double) chunksScanned) / 1_000_000.0;
    }

    public static void setVillageCandidates(int count) {
        villageCandidates = count;
    }

    public static void setWaypointCount(int count) {
        waypointCount = count;
    }
}