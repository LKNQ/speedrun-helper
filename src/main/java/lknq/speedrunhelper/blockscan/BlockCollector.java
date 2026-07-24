package lknq.speedrunhelper.blockscan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class BlockCollector {

    private final List<InterestingBlock> blocks = new ArrayList<>();

    private final EnumMap<InterestingBlockType, Integer> counts =
            new EnumMap<>(InterestingBlockType.class);

    public BlockCollector() {

        for (InterestingBlockType type : InterestingBlockType.values()) {
            counts.put(type, 0);
        }

    }

    public void add(InterestingBlock block) {

        blocks.add(block);

        counts.put(
                block.getType(),
                counts.get(block.getType()) + 1
        );

    }

    public int getCount(InterestingBlockType type) {
        return counts.get(type);
    }

    public List<InterestingBlock> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }

    public void clear() {
        blocks.clear();

        for (InterestingBlockType type : InterestingBlockType.values()) {
            counts.put(type, 0);
        }
    }

    public int size() {
        return blocks.size();
    }

    public boolean isEmpty() {
        return blocks.isEmpty();
    }
}