package lknq.speedrunhelper.blockscan;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.WorldChunk;

public class ChunkScanner {

    public static BlockCollector scan(WorldChunk chunk) {

        BlockCollector collector = new BlockCollector();

        ChunkPos chunkPos = chunk.getPos();

        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int y = 0; y < 256; y++) {

            for (int z = 0; z < 16; z++) {

                for (int x = 0; x < 16; x++) {

                    pos.set(
                            chunkPos.getStartX() + x,
                            y,
                            chunkPos.getStartZ() + z
                    );

                    BlockState state = chunk.getBlockState(pos);

                    Block block = state.getBlock();

                    InterestingBlockType type =
                            InterestingBlockClassifier.classify(block);

                    if (type == InterestingBlockType.UNKNOWN)
                        continue;

                    collector.add(new InterestingBlock(
                            pos.toImmutable(),
                            chunkPos,
                            block,
                            type
                    ));
                }
            }
        }

        return collector;
    }

}