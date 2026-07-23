package lknq.srh.data;

import java.util.*;

public class StructureCache{
    private final List<DetectedStructure> structures=new ArrayList<>();
    public void add(DetectedStructure s){structures.add(s);}
    public List<DetectedStructure> all(){return Collections.unmodifiableList(structures);}
}
