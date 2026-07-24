package lknq.speedrunhelper.detector;

import java.util.ArrayList;
import java.util.List;

import lknq.speedrunhelper.blockscan.BlockCollector;
import lknq.speedrunhelper.detector.impl.BastionDetector;
import lknq.speedrunhelper.detector.impl.DesertTempleDetector;
import lknq.speedrunhelper.detector.impl.FortressDetector;
import lknq.speedrunhelper.detector.impl.RuinedPortalDetector;
import lknq.speedrunhelper.detector.impl.VillageDetector;

public class DetectorManager {

    private final List<StructureDetector> detectors = new ArrayList<>();

    public DetectorManager() {

        detectors.add(new VillageDetector());
        detectors.add(new DesertTempleDetector());
        detectors.add(new RuinedPortalDetector());
        detectors.add(new FortressDetector());
        detectors.add(new BastionDetector());

    }

    public void scan(BlockCollector collector) {

        for (StructureDetector detector : detectors) {
            detector.scan(collector);
        }

    }

}