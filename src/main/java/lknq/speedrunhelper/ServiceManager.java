package lknq.speedrunhelper;

import lknq.speedrunhelper.detector.DetectorManager;
import lknq.speedrunhelper.scanner.ScannerManager;
import lknq.speedrunhelper.waypoint.WaypointManager;

public class ServiceManager {

    private static final ScannerManager scannerManager = new ScannerManager();
    private static final DetectorManager detectorManager = new DetectorManager();
    private static final WaypointManager waypointManager = new WaypointManager();

    public static void initialize() {
        SpeedrunHelper.log("Initializing services...");
    }

    public static ScannerManager getScannerManager() {
        return scannerManager;
    }

    public static DetectorManager getDetectorManager() {
        return detectorManager;
    }

    public static WaypointManager getWaypointManager() {
        return waypointManager;
    }
}