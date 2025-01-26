package ca.mcmaster.se2aa4.mazerunner;

public class Position {

    private int x;
    private int y;
    private Direction direction;
    private Maze maze;

    public Position(int x, int y, Direction direction, Maze maze) {

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maze = maze;

    }

    public void moveForward() {

        int newX = x;
        int newY = y;

        //move based on current direction
        switch (direction.getCurrentDirection()) {
            case "NORTH":
                newX--; //move up
                break;
            case "EAST":
                newY++; //move right
                break;
            case "SOUTH":
                newX++; //move down
                break;
            case "WEST":
                newY--; //move left
                break;
        }

        //validate the new position
        if (newX >= 0 && newY >= 0 && newX < maze.getRows() && newY < maze.getCols()) {
            if (maze.getTile(newX, newY) == ' ') { 
                this.x = newX;
                this.y = newY;
            } else {
                System.out.println("Hit a wall! Can't move forward."); //out-of-bound conditions
            }
        } else {
            System.out.println("Out of bounds! Can't move forward."); //out-of-bound conditions
        }
    }

    public void turnLeft() {
        direction.turnLeft();
    }

    public void turnRight() {
        direction.turnRight();
    }

    public String getCurrentPosition() {
        return "(" + x + ", " + y + ") facing " + direction.getCurrentDirection();
    }

    public int[] getCoordinates() {
        return new int[]{x, y};
    }
}