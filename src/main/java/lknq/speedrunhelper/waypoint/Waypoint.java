package lknq.speedrunhelper.waypoint;

import lknq.speedrunhelper.detector.StructureType;
import net.minecraft.util.math.BlockPos;

public class Waypoint {

    private final BlockPos pos;
    private final StructureType type;
    private final int confidence;

    public Waypoint(
            BlockPos pos,
            StructureType type,
            int confidence
    ) {
        this.pos = pos;
        this.type = type;
        this.confidence = confidence;
    }

    public BlockPos getPos() {
        return pos;
    }

    public StructureType getType() {
        return type;
    }

    public int getConfidence() {
        return confidence;
    }

}