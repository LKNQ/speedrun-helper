package lknq.speedrunhelper.detector.impl;

import lknq.speedrunhelper.ServiceManager;
import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.blockscan.InterestingBlock;
import lknq.speedrunhelper.blockscan.InterestingBlockType;
import lknq.speedrunhelper.debug.DebugStats;
import lknq.speedrunhelper.detector.StructureDetector;
import lknq.speedrunhelper.detector.StructureType;

public class VillageDetector implements StructureDetector {

    @Override
    public void scan(BlockCollector collector) {

        int score = collector.getCount(InterestingBlockType.VILLAGE);

        DebugStats.lastVillageScore = score;

        if (score < 8) {
            return;
        }

        InterestingBlock first = null;

        for (InterestingBlock block : collector.getBlocks()) {

            if (block.getType() == InterestingBlockType.VILLAGE) {
                first = block;
                break;
            }

        }

        if (first == null) {
            return;
        }

        ServiceManager.getDetectionManager().report(
                StructureType.VILLAGE,
                first.getPos(),
                score
        );

    }

}