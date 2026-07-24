package lknq.speedrunhelper.detector;

import net.minecraft.util.math.BlockPos;

public class DetectedStructure {

    private final StructureType type;
    private final BlockPos pos;
    private final int confidence;

    public DetectedStructure(
            StructureType type,
            BlockPos pos,
            int confidence
    ) {
        this.type = type;
        this.pos = pos;
        this.confidence = confidence;
    }

    public StructureType getType() {
        return type;
    }

    public BlockPos getPos() {
        return pos;
    }

    public int getConfidence() {
        return confidence;
    }

}