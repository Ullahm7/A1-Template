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
        int forwardCount = 0;  //count for consecutive 'F'
        String lastInstruction = "";  //to track the last valid instruction

        for (String instruction : instructions) {

            if (instruction.equals("F")) {
                //increment count for consecutive 'F'
                forwardCount++;
                lastInstruction = "F";  //update last instruction to 'F'

            } else {
                //if the moving forward count is non zero, append it
                if (forwardCount > 0) {
                    canonicalPath.append(forwardCount > 1 ? forwardCount : "").append("F"); //append forwards
                    forwardCount = 0; //reset for the next instruction
                }
                //append turns
                if (!instruction.equals(lastInstruction)) {
                    canonicalPath.append(instruction);  //append turn instruction
                    lastInstruction = instruction;  //then update last instruction
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
        return instructions; //return the list of instructions
    }
}
