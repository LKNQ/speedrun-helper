package lknq.speedrunhelper;

import lknq.speedrunhelper.detector.DetectionManager;
import lknq.speedrunhelper.detector.DetectorManager;
import lknq.speedrunhelper.scanner.ScannerManager;
import lknq.speedrunhelper.waypoint.WaypointManager;

public class ServiceManager {

    private static final ScannerManager scannerManager =
            new ScannerManager();

    private static final DetectorManager detectorManager =
            new DetectorManager();

    private static final DetectionManager detectionManager =
            new DetectionManager();

    private static final WaypointManager waypointManager =
            new WaypointManager();

    public static WaypointManager getWaypointManager() {
        return waypointManager;
    }

    public static void initialize() {
    }

    public static ScannerManager getScannerManager() {
        return scannerManager;
    }

    public static DetectorManager getDetectorManager() {
        return detectorManager;
    }

    public static DetectionManager getDetectionManager() {
        return detectionManager;
    }

}