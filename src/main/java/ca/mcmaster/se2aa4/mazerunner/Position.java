package ca.mcmaster.se2aa4.mazerunner;
import java.util.HashMap;
import java.util.Map;

public class Position {

    private int x;
    private int y;
    private Direction direction;
    private Maze maze;

    private static final Map<Direction, int[]> directionMoves = new HashMap<>();

    static {
        //for each direction, we specify the x and y movement for moving forward
        directionMoves.put(Direction.NORTH, new int[]{-1, 0}); //move up, so we decrease x
        directionMoves.put(Direction.EAST, new int[]{0, 1});  //move right, so we increase y
        directionMoves.put(Direction.SOUTH, new int[]{1, 0});  //move down so we increase x
        directionMoves.put(Direction.WEST, new int[]{0, -1}); //move left, so we decrease y
    }

    public Position(int x, int y, Direction direction, Maze maze) {

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.maze = maze;

    }

     public void moveForward() {

        //get x and y movement based on the current direction
        int[] move = directionMoves.get(direction);
        int newX = x + move[0];
        int newY = y + move[1];

        //new position
        if (maze.getTile(newX, newY) == ' ') {
            this.x = newX;
            this.y = newY;
            return true; //move was successful
        } else {
            return false; //move failed (hit a wall)
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void setDirection(Direction direction) {
        this.direction = direction; //set direction directly for exploration
    }

    public int[] getCoordinates() {
        return new int[]{x, y}; //get current coordinates as an array
    }

    public Direction getDirection() {
        return direction; 
    }
}