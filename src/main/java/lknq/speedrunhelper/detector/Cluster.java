package lknq.speedrunhelper.detector;

import lknq.speedrunhelper.blockscan.InterestingBlock;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private final List<InterestingBlock> blocks = new ArrayList<>();

    public void add(InterestingBlock block) {
        blocks.add(block);
    }

    public List<InterestingBlock> getBlocks() {
        return blocks;
    }

    public int size() {
        return blocks.size();
    }

    public BlockPos getCenter() {

        if (blocks.isEmpty())
            return BlockPos.ORIGIN;

        int x = 0;
        int y = 0;
        int z = 0;

        for (InterestingBlock block : blocks) {
            x += block.getPos().getX();
            y += block.getPos().getY();
            z += block.getPos().getZ();
        }

        int count = blocks.size();

        return new BlockPos(
                x / count,
                y / count,
                z / count
        );
    }

    public boolean isNear(InterestingBlock block, int radius) {

        for (InterestingBlock existing : blocks) {

            if (existing.getPos().isWithinDistance(block.getPos(), radius))
                return true;

        }

        return false;
    }
}