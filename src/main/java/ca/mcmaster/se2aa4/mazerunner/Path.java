package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<String> instructions; //list of instructions: forward, left, or right

    public Path() {

        instructions = new ArrayList<>();

    }

    public void addInstruction(String instruction) {

        instructions.add(instruction);

    }

    public String getCanonicalPath() {

        StringBuilder canonicalPath = new StringBuilder();
        int forwardCount = 0;  //count for consecutive 'F'
        String lastInstruction = "";  //to track the last valid instruction

        for (String instruction : instructions) {

            if (instruction.equals("F")) {
                //increment count for consecutive 'F'
                forwardCount++;
                lastInstruction = "F";  // Update last instruction to 'F'

            } else if ("R".equals(instruction) || "L".equals(instruction)) {
                //if moving forward count is non-zero, append it
                if (forwardCount > 0) {

                    canonicalPath.append(forwardCount > 1 ? forwardCount : "").append("F");
                    forwardCount = 0;  

                }
                
                //append the turn if it's different from the last turn
                if (!instruction.equals(lastInstruction)) {

                    canonicalPath.append(instruction);  //append turn instruction

                    lastInstruction = instruction;  
                }
            }
        }

        //append any remaining forward moves at the end of the iteration
        if (forwardCount > 0) {

            canonicalPath.append(forwardCount > 1 ? forwardCount : "").append("F");
        }

        return canonicalPath.toString();
    }

    public List<String> getInstructions() {
        return instructions;
    }
}