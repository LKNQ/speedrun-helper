package lknq.speedrunhelper.scanner;

import lknq.speedrunhelper.SpeedrunHelper;

public class ChunkScanner {

    public void scanChunk(int chunkX, int chunkZ) {

        SpeedrunHelper.log(
                "Scanning chunk " + chunkX + ", " + chunkZ
        );

        ChunkData chunk = new ChunkData(chunkX, chunkZ);

        // detectors will go here

    }

}