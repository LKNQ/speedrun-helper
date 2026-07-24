package lknq.speedrunhelper;

import lknq.speedrunhelper.detector.DetectorManager;
import lknq.speedrunhelper.scanner.ScannerManager;
import lknq.speedrunhelper.waypoint.WaypointManager;

public final class ServiceManager {

    private static final ScannerManager SCANNER_MANAGER = new ScannerManager();
    private static final DetectorManager DETECTOR_MANAGER = new DetectorManager();
    private static final WaypointManager WAYPOINT_MANAGER = new WaypointManager();

    private ServiceManager() {
    }

    public static void initialize() {
        System.out.println("[Speedrun Helper] Initializing services...");
    }

    public static ScannerManager scanner() {
        return SCANNER_MANAGER;
    }

    public static DetectorManager detectors() {
        return DETECTOR_MANAGER;
    }

    public static WaypointManager waypoints() {
        return WAYPOINT_MANAGER;
    }
}
