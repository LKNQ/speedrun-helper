package lknq.speedrunhelper.debug;

public final class DebugOverlay {

    private static boolean enabled = true;

    private DebugOverlay() {}

    public static boolean isEnabled() {
        return enabled;
    }

    public static void toggle() {
        enabled = !enabled;
    }
}