package lknq.speedrunhelper.detector;

import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.blockscan.InterestingBlock;

import java.util.ArrayList;
import java.util.List;

public class ClusterDetector {

    private static final int CLUSTER_RADIUS = 48;

    public static List<Cluster> build(BlockCollector collector) {

        List<Cluster> clusters = new ArrayList<>();

        for (InterestingBlock block : collector.getBlocks()) {

            Cluster found = null;

            for (Cluster cluster : clusters) {

                if (cluster.isNear(block, CLUSTER_RADIUS)) {
                    found = cluster;
                    break;
                }

            }

            if (found == null) {

                found = new Cluster();
                clusters.add(found);

            }

            found.add(block);

        }

        return clusters;

    }

}