package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

    private char[][] grid; //create a grid either a wall or empty
    private int rows; 
    private int cols;

    public Maze(String filePath) { //constructor passing in the maze file 

        loadMaze(filePath);

    }

    private void loadMaze(String filePath) {
        //initialize to null or 0
        BufferedReader reader = null; 
        String line;
        rows = 0;
        cols = 0;

        //create maze dimension
        reader = new BufferedReader(new FileReader(filePath)); //buffered instance to read line
        while ((line = reader.readLine()) != null) { //loop while null

            if (line.length() > cols) {

                cols = line.length(); //updates if the current col is greater than previous 

            }

            rows++; //each new line, a new row is updated

        }

        grid = new char[rows][cols]; //creates a grid

        reader.close();
        reader = new BufferedReader(new FileReader(filePath));
        int rowIndex = 0;

        //fill the dimensions with either empty or full
        while ((line = reader.readLine()) != null) {
            for (int colIndex = 0; colIndex < line.length(); colIndex++) {
                grid[rowIndex][colIndex] = line.charAt(colIndex);
            }
            rowIndex++;
        }
        reader.close(); 
    }

    //returns a specific character at a specific position
    public char getTile(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            return grid[x][y];
        }
        return '#'; //used as a placeholder if not in grid
    }

    //getter and setters for other classes
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    //method to find the entry point
    public int[] getEntryPoint() {
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == ' ') {
                return new int[]{i, 0}; //
            }
        }
        return null; // No entry point found
    }

    //method to find the exit point
    public int[] getExitPoint() {
        for (int i = 0; i < rows; i++) {
            if (grid[i][cols - 1] == ' ') {
                return new int[]{i, cols - 1}; //
            }
        }
        return null; //no exit point found, placeholder for now 
    }
}