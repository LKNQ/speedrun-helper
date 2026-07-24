package lknq.speedrunhelper.scanner;

import lknq.speedrunhelper.blockscan.BlockCollector;

public class ChunkData {

    private final int chunkX;
    private final int chunkZ;
    private final BlockCollector blocks;

    public ChunkData(int chunkX, int chunkZ, BlockCollector blocks) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
        this.blocks = blocks;
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

    public BlockCollector getBlocks() {
        return blocks;
    }
}