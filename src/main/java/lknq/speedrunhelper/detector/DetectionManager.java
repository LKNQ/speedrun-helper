package lknq.speedrunhelper.detector;

import net.minecraft.util.math.BlockPos;
import lknq.speedrunhelper.debug.DebugStats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetectionManager {

    private static final int MERGE_DISTANCE = 160;

    private final List<DetectedStructure> structures =
            new ArrayList<>();

    public void report(
            StructureType type,
            BlockPos pos,
            int confidence
    ) {

        for (int i = 0; i < structures.size(); i++) {

            DetectedStructure existing =
                    structures.get(i);

            if (existing.getType() != type)
                continue;

            if (existing.getPos().isWithinDistance(
                    pos,
                    MERGE_DISTANCE
            )) {

                if (confidence > existing.getConfidence()) {

                    structures.set(
                            i,
                            new DetectedStructure(
                                    type,
                                    pos,
                                    confidence
                            )
                    );

                }

                return;
            }

        }

        structures.add(
                new DetectedStructure(
                        type,
                        pos,
                        confidence
                )
        );

        DebugStats.detectedStructures = structures.size();

    }

    public List<DetectedStructure> getStructures() {
        return Collections.unmodifiableList(structures);
    }

}