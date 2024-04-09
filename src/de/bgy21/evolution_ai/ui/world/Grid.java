package de.bgy21.evolution_ai.ui.world;

import java.util.ArrayList;

public class Grid {
    GridObject[][] grids;
    float height, width;
    int columns, rows;

    public Grid(float height, float width, int columns, int rows) {
        this.grids = new GridObject[columns][rows];
        this.height = height;
        this.width = width;
        this.columns = columns;
        this.rows = rows;
    }

    public void addGridObject(int column, int row, GridObject gridObject){
        grids[column][row] = gridObject;

    }

}
