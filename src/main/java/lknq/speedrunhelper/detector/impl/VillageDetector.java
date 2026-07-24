package lknq.speedrunhelper.detector.impl;

import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.blockscan.InterestingBlockType;
import lknq.speedrunhelper.debug.DebugStats;
import lknq.speedrunhelper.detector.StructureDetector;

public class VillageDetector implements StructureDetector {

    @Override
    public void scan(BlockCollector collector) {

        int score = collector.getCount(InterestingBlockType.VILLAGE);

        DebugStats.lastVillageScore = score;

        if (score >= 8) {

            DebugStats.villageCandidates++;

            System.out.println(
                    "[VillageDetector] Village candidate (" +
                            score +
                            " blocks)"
            );

        }

    }

}