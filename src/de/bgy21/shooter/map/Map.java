package de.bgy21.shooter.map;

import org.lwjgl.util.vector.Vector2f;

public class Map {
    public static final int[][] FirstMap = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    private int[][] mapStructure;
    private float fieldWidth;

    public Map(int[][] mapStructure, int fieldWidth) {
        this.mapStructure = mapStructure;
        this.fieldWidth = fieldWidth;
    }

    public int check_collision(Vector2f position) {
        int index_x = (int) Math.ceil(position.x / this.fieldWidth);
        int index_y = (int)  Math.ceil(position.y / this.fieldWidth);

        if (index_x < 0 || index_y < 0) {
            return 0;
        }
        
        return mapStructure[index_x][index_y];
    }
}
