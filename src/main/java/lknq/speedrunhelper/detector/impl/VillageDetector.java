package lknq.speedrunhelper.detector.impl;

import lknq.speedrunhelper.ServiceManager;
import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.blockscan.InterestingBlock;
import lknq.speedrunhelper.blockscan.InterestingBlockType;
import lknq.speedrunhelper.debug.DebugStats;
import lknq.speedrunhelper.detector.Cluster;
import lknq.speedrunhelper.detector.ClusterDetector;
import lknq.speedrunhelper.detector.StructureDetector;
import lknq.speedrunhelper.detector.StructureType;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class VillageDetector implements StructureDetector {

    @Override
    public void scan(BlockCollector collector) {

        System.out.println("========== INTERESTING BLOCKS ==========");

        for (InterestingBlock block : collector.getBlocks()) {
            System.out.println(
                    block.getBlock()
                            + " | "
                            + block.getType()
                            + " | "
                            + block.getPos()
            );
        }

        System.out.println("========================================");

        List<Cluster> clusters = ClusterDetector.build(collector);

        Cluster bestCluster = null;
        int bestScore = 0;

        int clusterIndex = 1;

        for (Cluster cluster : clusters) {

            int score = 0;

            System.out.println("----- Cluster #" + clusterIndex + " -----");

            for (InterestingBlock block : cluster.getBlocks()) {

                System.out.println(
                        block.getBlock()
                                + " | "
                                + block.getType()
                                + " | "
                                + block.getPos()
                );

                if (block.getType() == InterestingBlockType.VILLAGE) {
                    score++;
                }
            }

            System.out.println("Cluster score = " + score);
            System.out.println("Cluster center = " + cluster.getCenter());

            if (score > bestScore) {
                bestScore = score;
                bestCluster = cluster;
            }

            clusterIndex++;
        }

        DebugStats.lastVillageScore = bestScore;

        if (bestCluster == null || bestScore < 8) {
            return;
        }

        BlockPos center = bestCluster.getCenter();

        System.out.println("===== SELECTED CLUSTER =====");
        System.out.println("Center = " + center);
        System.out.println("Score = " + bestScore);
        System.out.println("============================");

        ServiceManager.getDetectionManager().report(
                StructureType.VILLAGE,
                center,
                bestScore
        );
    }
}