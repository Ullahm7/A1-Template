package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        
        logger.info("** Starting Maze Runner");

        //argument for -i flag
        Options options = new Options();
        Option fileOption = new Option("i", true, "File that contains maze");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        //argument for -p flag
        options.addOption(new Option("p", true, "Maze path to be verified"));
        CommandLineParser parser = new DefaultParser(); 

        try {
            CommandLine commandLine = parser.parse(options, args);
            String filePath = commandLine.getOptionValue('i'); //file assign text
            Maze maze = new Maze(filePath);

            if(commandLine.getOptionValue("p")!= null){ //if -p is not null
                logger.info("Validating maze path"); //have to validate path
                
                Path path = new Path(commandLine.getOptionValue("p")); 
                PathValidator validator = new PathValidator(maze);  
                boolean valid = validator.checkPath(path);

                if(valid){
                    System.out.println("correct path");
                }
                else{
                    System.out.println("incorrect path");
                }
            }

            else{ //finding path for maze only
                logger.info("**** Computing path");
                logger.info(" " + maze.toString());

                Solver solver = chooseSolver();
                Path path = solver.solve(maze);

                System.out.println(path.getFactorized());
            }
    
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
            logger.error(e.getMessage());
            logger.error("PATH NOT COMPUTED");
        }
    
        logger.info("** End of MazeRunner");
    }

    public static Solver chooseSolver(){
        return new Solver();
    }

}
