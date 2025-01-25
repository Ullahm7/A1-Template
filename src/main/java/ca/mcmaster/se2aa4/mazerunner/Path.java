package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<String> instructions;

    public Path() {
        instructions = new ArrayList<>();
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    public String getCanonicalPath() {
        //convert instructions to canonical form (squash similar instructions)
        return canonicalPath;
    }

    //additional methods as needed 
}