package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MazeInitialize {
 
    private static final Logger logger = LogManager.getLogger();

    public static Options setUpOptions() {
        Options options = new Options();
        options.addOption("i", "input", true, "File for maze");
        options.addOption("p", "path", true, "Path to validate");
        return options;
    }

    public static CommandLine parseCommandLine(String[] args, Options options) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }

    public static Position initializePosition(Maze maze) {
        int[] entryPoint = maze.getEntryPoint(); //get entry coordinates
        if (entryPoint == null) {
            throw new IllegalArgumentException("No valid entry point found in the maze.");
        }
        return new Position(entryPoint[0], entryPoint[1], Direction.EAST, maze); //start facing EAST
    }

    public static Path exploreMaze(Position position, Maze maze) {
        Path path = new Path(); //new path to record movements
        //basic exploration logic
        while (true) {
            if (isAtExit(position, maze)) { //check if the exit is reached
                logger.info("Reached the exit!");
                break;
            }

            boolean moved = false;
            for (Direction dir : Direction.values()) {
                position.setDirection(dir); // Set direction to check
                if (position.moveForward()) {
                    path.addInstruction("F");
                    moved = true;
                    break; //break on first valid move
                }
            }

            if (!moved) {
                break; //no valid moves, exit
            }
        }
        return path;
    }

    public static void verifyPath(Maze maze, String pathToVerify) {
        Position position = initializePosition(maze);
        boolean isValid = true;

        for (char command : pathToVerify.toCharArray()) {
            switch (command) {
                case 'F':
                    if (!position.moveForward()) isValid = false; //move must be valid
                    break;
                case 'R':
                    position.turnRight();
                    break;
                case 'L':
                    position.turnLeft();
                    break;
                default:
                    logger.error("Invalid command in path: " + command);
                    isValid = false;
                    break;
            }
        }

        if (isValid && isAtExit(position, maze)) {
            System.out.println("correct path");
        } else {
            System.out.println("incorrect path");
        }
    }

    private static boolean isAtExit(Position position, Maze maze) {
        int[] currentPos = position.getCoordinates();
        int[] exitPoint = maze.getExitPoint();
        return currentPos[0] == exitPoint[0] && currentPos[1] == exitPoint[1];
    }
}