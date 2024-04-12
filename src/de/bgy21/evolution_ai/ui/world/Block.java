package de.bgy21.evolution_ai.ui.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;

public class Block extends GridObject{

    public Block(int posX, int posY, int size_x, int size_y) {
        super(posX, posY, size_x, size_y, true);
    }


    @Override
    public void render(Graphics graphics, float scaleMultX, float scaleMultY) {
        graphics.fill(new Rectangle(this.posX * scaleMultX, this.posY * scaleMultY, size_x * scaleMultX, size_y * scaleMultY));
    }
}
