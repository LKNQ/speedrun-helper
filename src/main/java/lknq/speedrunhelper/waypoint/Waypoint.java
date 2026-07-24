package lknq.speedrunhelper.waypoint;

import lknq.speedrunhelper.detector.StructureType;

public class Waypoint {

    private final StructureType type;

    private final int x;
    private final int y;
    private final int z;

    public Waypoint(StructureType type, int x, int y, int z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public StructureType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}