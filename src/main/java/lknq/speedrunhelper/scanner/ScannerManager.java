package lknq.speedrunhelper.scanner;

import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.blockscan.ChunkScanner;
import net.minecraft.world.chunk.WorldChunk;

public class ScannerManager {

    public void onChunkLoaded(WorldChunk chunk) {

        BlockCollector collector = ChunkScanner.scan(chunk);

        System.out.println(
                "[Scanner] "
                        + collector.size()
                        + " interesting blocks | total chunks="
                        + lknq.speedrunhelper.debug.DebugStats.chunksScanned
        );

    }

}