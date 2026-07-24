package lknq.speedrunhelper.blockscan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockCollector {

    private final List<InterestingBlock> blocks = new ArrayList<>();

    public void add(InterestingBlock block) {
        blocks.add(block);
    }

    public List<InterestingBlock> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    public void clear() {
        blocks.clear();
    }

    public int size() {
        return blocks.size();
    }

    public boolean isEmpty() {
        return blocks.isEmpty();
    }
}