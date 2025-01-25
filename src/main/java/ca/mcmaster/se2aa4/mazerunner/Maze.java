package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    private char[][] grid;
    private int rows;
    private int cols;

    public Maze(String filePath) throws IOException {
        loadMaze(filePath);
    }

    private void loadMaze(String filePath) throws IOException {
        //implement reading the maze from the file and populating the grid.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //count number of rows and columns
            //then load the grid
        }
    }

    public char getTile(int x, int y) {
        return grid[x][y];
    }

    //additional methods to find entry & exit points, check if a position is valid, etc
}