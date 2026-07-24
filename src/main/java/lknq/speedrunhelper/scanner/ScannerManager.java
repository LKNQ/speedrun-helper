package lknq.speedrunhelper.scanner;

import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.blockscan.ChunkScanner;
import net.minecraft.world.chunk.WorldChunk;
import lknq.speedrunhelper.ServiceManager;
import lknq.speedrunhelper.debug.DebugStats;

public class ScannerManager {

    public void onChunkLoaded(WorldChunk chunk) {

        BlockCollector collector = ChunkScanner.scan(chunk);

        ServiceManager.getDetectorManager().scan(collector);

        System.out.println(
                "[Scanner] "
                        + collector.size()
                        + " interesting blocks | total chunks="
                        + DebugStats.chunksScanned
        );

    }

}