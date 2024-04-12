package de.bgy21.evolution_ai.ui.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Ellipse;

abstract public class GridObject {
    protected int posX, posY;
    protected int size_x, size_y;
    protected boolean collision;


    public GridObject(int posX, int posY, int size_x, int size_y, boolean collision) {
        this.posX = posX;
        this.posY = posY;
        this.size_x = size_x;
        this.size_y = size_y;
        this.collision = collision;
    }

    abstract public void render(Graphics graphics, float scaleMultX, float scaleMultY);
}
