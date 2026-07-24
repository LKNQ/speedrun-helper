package lknq.speedrunhelper.waypoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaypointManager {

    private final List<Waypoint> waypoints = new ArrayList<>();

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
    }

    public void clear() {
        waypoints.clear();
    }

    public List<Waypoint> getWaypoints() {
        return Collections.unmodifiableList(waypoints);
    }

}