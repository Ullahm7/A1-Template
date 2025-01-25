package ca.mcmaster.se2aa4.mazerunner;

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    //getters, setters, and methods for moving and turning
    public void moveForward() {
        //modify x and y based on the current direction
    }

    public void turnLeft() {
        //change to the left
    }

    public void turnRight() {
        //change to the right
    }
}