package de.bgy21.evolution_ai.ui.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;

public class Block extends GridObject{

    public Block(int posX, int posY, int size_x, int size_y) {
        super(posX, posY, size_x, size_y, true);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.draw(new Rectangle(this.posX, this.posY, 10, 10));
    }
}
