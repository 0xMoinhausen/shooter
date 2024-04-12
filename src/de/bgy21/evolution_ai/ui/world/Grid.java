package de.bgy21.evolution_ai.ui.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Grid {
    ArrayList<GridObject> grid = new ArrayList<>();
    float width, height;
    private float  widthMult, heightMult;

    private long tick = 0;
    int columns, rows;

    private Random random = new Random();
    public Grid(float height, float width, int columns, int rows) {
        this.height = height;
        this.width = width;
        this.columns = columns;
        this.rows = rows;
        this.widthMult = width / columns;
        this.heightMult = height / rows;
    }

    public void addGridObject(GridObject gridObject){
        grid.add(gridObject);

    }

    public void clearGrid(){
        grid.clear();
    }
    public void render(Graphics graphics){
        graphics.draw(new Rectangle(1, 1, width - 1, height - 1));
        grid.forEach(gridObject -> {
            gridObject.render(graphics, widthMult, heightMult);
        });

        graphics.drawString("Current Tick: " + tick, 0, 0);
    }

    public void update(){
        tick++;
        if(tick % 1000 == 0){
            reset(20);
        }
    }

    private void reset(int numberBlock){
        clearGrid();
        boolean[][] seen = MazeGenerator.generateMaze(columns, rows);

        for(int y = 0; y < seen.length; y++){
            for(int x = 0; x < seen[ 0].length; x++){
                if(seen[y][x]){
                    addGridObject(new Block(x, y, 1, 1));
                }

            }
        }
        //for (int block = 0; block < numberBlock; block++) {
         //   addGridObject(new Block(random.nextInt(columns), random.nextInt(rows), 1, 1));
            //addGridObject(new Block(1, 1, 1, 1));
        //}
    }


    private boolean[][] depthFirstSearch(int posX, int posY, boolean[][] seen){
        addGridObject(new Block(posX, posY, 1, 1));
        while(random.nextBoolean()){
            int nextPosX = posX + random.nextInt(3) - 1;
            int nextPosY = posY + random.nextInt(3) - 1;
            seen[posX][posY] = true;
            if(nextPosX < 0 || nextPosX >= columns-1 || nextPosY < 0 || nextPosY >= rows - 1){
                break;
            }
            depthFirstSearch(nextPosX, nextPosY, seen);
        }
        return seen;
    }
}
