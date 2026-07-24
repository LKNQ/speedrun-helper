package lknq.speedrunhelper.scanner;

public class ChunkData {

    private final int chunkX;
    private final int chunkZ;

    public ChunkData(int chunkX, int chunkZ) {
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

}