package de.bgy21.evolution_ai.ui.screens.flappybird;


import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class FlappyBirdInstance {

    private Shape bird = new Circle(1, 1, 1);

    public void render(Graphics graphics){
        graphics.fill(bird);
    }
}
