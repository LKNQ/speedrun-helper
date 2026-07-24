package lknq.speedrunhelper.detector;

import lknq.speedrunhelper.blockscan.BlockCollector;

public interface StructureDetector {

    void scan(BlockCollector collector);

}