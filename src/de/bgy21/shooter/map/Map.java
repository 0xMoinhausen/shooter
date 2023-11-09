package de.bgy21.shooter.map;

public class Map {
    public static final int[][] FirstMap = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    private int[][] mapStructure;
    private int fieldWidth;

    public Map(int[][] mapStructure, int fieldWidth) {
        this.mapStructure = mapStructure;
        this.fieldWidth = fieldWidth;
    }
}
