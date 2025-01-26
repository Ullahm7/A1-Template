package ca.mcmaster.se2aa4.mazerunner;

public class Direction {

    private static final String[] DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"};
    private int index; //used to track direction

    public Direction(String initialDirection) {
        //initializing directional index based on the initial direction using a switch statement
        switch (initialDirection) {
            case "NORTH":
                this.index = 0;
                break;
            case "EAST":
                this.index = 1;
                break;
            case "SOUTH":
                this.index = 2;
                break;
            case "WEST":
                this.index = 3;
                break;
            default:
                throw new IllegalArgumentException("Invalid initial direction");
        }
    }

    public String getCurrentDirection() {

        return DIRECTIONS[index];

    }

    public void turnLeft() {

        index = (index + 3) % 4; //turn left (counter-clockwise)

    }

    public void turnRight() {

        index = (index + 1) % 4; //turn right (clockwise)

    }

    public int getIndex() {

        return index; //used for movement
        
    }
}