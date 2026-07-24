package lknq.speedrunhelper.scanner;

import net.minecraft.world.chunk.WorldChunk;

public class ScannerManager {

    private final ChunkScanner scanner = new ChunkScanner();

    public void onChunkLoaded(WorldChunk chunk) {

        scanner.scanChunk(
                chunk.getPos().x,
                chunk.getPos().z
        );

    }

}