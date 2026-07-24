package lknq.speedrunhelper.blockscan;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class InterestingBlockClassifier {

    public static InterestingBlockType classify(Block block) {

        if (block == Blocks.BELL
                || block == Blocks.BLAST_FURNACE
                || block == Blocks.SMITHING_TABLE
                || block == Blocks.LECTERN
                || block == Blocks.CARTOGRAPHY_TABLE
                || block == Blocks.COMPOSTER
                || block == Blocks.BARREL
                || block == Blocks.BREWING_STAND
                || block == Blocks.GRINDSTONE) {
            return InterestingBlockType.VILLAGE;
        }

        if (block == Blocks.CRYING_OBSIDIAN
                || block == Blocks.OBSIDIAN
                || block == Blocks.GOLD_BLOCK
                || block == Blocks.NETHERRACK
                || block == Blocks.MAGMA_BLOCK) {
            return InterestingBlockType.RUINED_PORTAL;
        }

        if (block == Blocks.BLUE_TERRACOTTA
                || block == Blocks.ORANGE_TERRACOTTA
                || block == Blocks.CHISELED_SANDSTONE) {
            return InterestingBlockType.DESERT_TEMPLE;
        }

        if (block == Blocks.NETHER_BRICKS
                || block == Blocks.NETHER_BRICK_FENCE
                || block == Blocks.NETHER_WART_BLOCK) {
            return InterestingBlockType.FORTRESS;
        }

        return InterestingBlockType.UNKNOWN;
    }

}