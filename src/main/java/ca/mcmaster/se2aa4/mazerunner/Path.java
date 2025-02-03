package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<String> instructions; //list of instructions such as forward, left, or right

    public Path() {

        instructions = new ArrayList<>(); //creates an instruction array

    }

    public void addInstruction(String instruction) {

        instructions.add(instruction); //adds instructions

    }

    public String getCanonicalPath() {
        StringBuilder canonicalPath = new StringBuilder();
        int forwardCount = 0;  // Count for consecutive 'F'

        for (String instruction : instructions) {
            if (instruction.equals("F")) {
                forwardCount++;
            } else {
                if (forwardCount > 0) {
                    canonicalPath.append(forwardCount > 1 ? forwardCount : "").append("F");
                    forwardCount = 0; // Reset for the next instruction
                }
                canonicalPath.append(instruction); // Append turns
            }
        }

        // Append remaining forward moves if any
        if (forwardCount > 0) {
            canonicalPath.append(forwardCount > 1 ? forwardCount : "").append("F");
        }

        return canonicalPath.toString();
    }

    public List<String> getInstructions() {
        return instructions;
    }
}
