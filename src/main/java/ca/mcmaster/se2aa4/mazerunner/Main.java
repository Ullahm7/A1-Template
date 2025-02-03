package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Options options = MazeInitialize.setUpOptions();
        logger.info("** Starting Maze Runner");

        try {
            CommandLine cmd = MazeInitialize.parseCommandLine(args, options);
            String inputFile = cmd.getOptionValue("i");
            logger.info("**** Reading the maze from file " + inputFile);
           
            Maze maze = new Maze(inputFile);

            String pathToVerify = cmd.getOptionValue("p");
            if (pathToVerify != null) {
                MazeInitialize.verifyPath(maze, pathToVerify);
            } else {
                Position position = MazeInitialize.initializePosition(maze);
                Path path = MazeInitialize.exploreMaze(position, maze);
                String factorizedPath = path.getCanonicalPath();
                System.out.println("Factorized Path: " + factorizedPath);
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\", e);
        }

        logger.info("** End of MazeRunner");
    }
}
