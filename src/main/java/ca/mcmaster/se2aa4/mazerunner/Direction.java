package ca.mcmaster.se2aa4.mazerunner;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


public enum Direction {
    NORTH, EAST, SOUTH, WEST; //direction that is facing

    private static final Map<Direction, Direction> rightTurns = new HashMap<>();
    private static final Map<Direction, Direction> leftTurns = new HashMap<>();

    //stores values of turn left and rights
    static {
        rightTurns.put(NORTH, EAST);
        rightTurns.put(EAST, SOUTH);
        rightTurns.put(SOUTH, WEST);
        rightTurns.put(WEST, NORTH);

        leftTurns.put(NORTH, WEST);
        leftTurns.put(EAST, NORTH);
        leftTurns.put(SOUTH, EAST);
        leftTurns.put(WEST, SOUTH);
    }

    public Direction turnRight() {

        return rightTurns.get(this); //turn right clockwise

    }

    public Direction turnLeft() {

        return leftTurns.get(this); //turn left counter-clockwise
         
    }
}