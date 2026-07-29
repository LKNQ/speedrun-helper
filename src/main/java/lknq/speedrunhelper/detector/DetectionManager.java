package lknq.speedrunhelper.detector;

import lknq.speedrunhelper.debug.DebugStats;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import lknq.speedrunhelper.ServiceManager;
import lknq.speedrunhelper.waypoint.Waypoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

            DetectedStructure existing = structures.get(i);

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

                DebugStats.detectedStructures = structures.size();
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

        ServiceManager.getWaypointManager().clear();

        for (DetectedStructure structure : structures) {

            ServiceManager.getWaypointManager().add(
                    new Waypoint(
                            structure.getPos(),
                            structure.getType(),
                            structure.getConfidence()
                    )
            );

        }

        DebugStats.detectedStructures = structures.size();
    }

    public List<DetectedStructure> getStructures() {
        return Collections.unmodifiableList(structures);
    }

    public List<DetectedStructure> getNearest(int limit) {

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player == null)
            return Collections.emptyList();

        List<DetectedStructure> copy =
                new ArrayList<>(structures);

        copy.sort(Comparator.comparingDouble(s ->
                s.getPos().getSquaredDistance(client.player.getPos(), true)));

        if (copy.size() > limit)
            return copy.subList(0, limit);

        return copy;
    }

}