package lknq.speedrunhelper.blockscan;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;

public class InterestingBlock {

    private final BlockPos pos;
    private final ChunkPos chunkPos;
    private final Block block;
    private final InterestingBlockType type;

    public InterestingBlock(BlockPos pos, ChunkPos chunkPos, Block block, InterestingBlockType type) {
        this.pos = pos;
        this.chunkPos = chunkPos;
        this.block = block;
        this.type = type;
    }

    public BlockPos getPos() {
        return pos;
    }

    public ChunkPos getChunkPos() {
        return chunkPos;
    }

    public Block getBlock() {
        return block;
    }

    public InterestingBlockType getType() {
        return type;
    }
}