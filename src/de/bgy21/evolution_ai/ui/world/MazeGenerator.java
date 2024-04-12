package de.bgy21.evolution_ai.ui.world;

import java.util.*;

public class MazeGenerator {

    public static boolean[][] generateMaze(int width, int height) {
        boolean[][] maze = new boolean[height][width];
        // Initialize maze with walls
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = true;  // true means wall, false means path
            }
        }

        // Choose random starting point
        Random random = new Random();
        int startX = random.nextInt(width);
        int startY = random.nextInt(height);

        // Generate the maze starting from the random point
        generatePath(startX, startY, maze, width, height);

        return maze;
    }

    private static void generatePath(int x, int y, boolean[][] maze, int width, int height) {
        maze[x][y] = false;  // Set current cell to path

        // Directions for movement: Up, Down, Left, Right
        int[][] directions = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}};
        Collections.shuffle(Arrays.asList(directions)); // Randomize the directions

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Check if the new position is within bounds and not visited yet
            if (newX > 0 && newX < width - 1 && newY > 0 && newY < height - 1 && maze[newX][newY]) {
                int wallX = x + dir[0] / 2;  // X-coordinate of the wall to break
                int wallY = y + dir[1] / 2;  // Y-coordinate of the wall to break
                maze[wallX][wallY] = false;  // Break the wall between current cell and new cell
                generatePath(newX, newY, maze, width, height);    // Recursively call generatePath for the new cell
            }
        }
    }
}