package lknq.speedrunhelper.waypoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaypointManager {

    private final List<Waypoint> waypoints =
            new ArrayList<>();

    public void clear() {
        waypoints.clear();
    }

    public void add(Waypoint waypoint) {
        waypoints.add(waypoint);
    }

    public List<Waypoint> getWaypoints() {
        return Collections.unmodifiableList(waypoints);
    }

}