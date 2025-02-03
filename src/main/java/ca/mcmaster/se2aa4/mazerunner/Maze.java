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
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            rows = 0;
            cols = 0;
            while ((line = reader.readLine()) != null) {
                if (line.length() > cols) {
                    cols = line.length();
                }
                rows++;
            }

            grid = new char[rows][cols]; 
            reader.mark(1000);  //reset the reader to read again
            reader.reset();
            int rowIndex = 0;

            while ((line = reader.readLine()) != null) {
                for (int colIndex = 0; colIndex < line.length(); colIndex++) {
                    grid[rowIndex][colIndex] = line.charAt(colIndex);
                }
                rowIndex++;
            }
        } catch (IOException e) {
            System.err.println("Error reading maze file: " + e.getMessage());
        }
    }

    public char getTile(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            return grid[x][y];
        }
        return '#'; //treat out-of-bounds as a wall
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[] getEntryPoint() {
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == ' ') {
                return new int[]{i, 0}; //entry found at the leftmost column
            }
        }
        return null;
    }

    public int[] getExitPoint() {
        for (int i = 0; i < rows; i++) {
            if (grid[i][cols - 1] == ' ') {
                return new int[]{i, cols - 1}; //exit found at the rightmost column
            }
        }
        return null; 
    }
}