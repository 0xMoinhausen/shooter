package de.bgy21.evolution_ai.ui.screens.flappybird;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class Pipes {
    static Image pipeSprite;
    static Random random = new Random();
    static {
        try {
            pipeSprite = new Image("assets/flappybird/sprites/pipe-red.png").getScaledCopy(1.5f);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    private int posX, gapSize;
    public int gapY;
    private float speedX, pipeMoveSpeed;
    private Shape bottomHitbox, topHitbox;

    public Pipes(int posXOffset){
        this.posX = 500 + posXOffset;
        gapY = random.nextInt(Display.getHeight() - gapSize) + gapSize / 2;
        gapSize = 200;
        speedX = 20f;
        pipeMoveSpeed = 0.20f;
        topHitbox = new Rectangle(posX, gapY - gapSize/2, pipeSprite.getWidth(), -pipeSprite.getHeight() * 10);
        bottomHitbox = new Rectangle(posX, gapY + gapSize/2, pipeSprite.getWidth(), pipeSprite.getHeight() * 10);
    }

    public void render(Graphics graphics){
        graphics.draw(topHitbox);
        graphics.draw(bottomHitbox);

        graphics.drawImage(pipeSprite, posX, gapY + gapSize / 2);
        graphics.rotate(posX + pipeSprite.getWidth() / 2, gapY, 180);
        graphics.drawImage(pipeSprite, posX, gapY + gapSize / 2);
        graphics.rotate(posX + pipeSprite.getWidth() / 2, gapY, -180);
    }

    public void update(float delta, GameContainer container){
        speedX = pipeMoveSpeed * delta;
        posX -= speedX;
        if(posX <= 0){
            posX = Display.getWidth();
            gapY = random.nextInt((int)(container.getHeight() *0.8 - gapSize)) + gapSize / 2;
        }
        topHitbox.setLocation(posX, gapY - gapSize/2);
        bottomHitbox.setLocation(posX, gapY + gapSize/2);
        //posX = posX % Display.getWidth();
    }

    public boolean colliding(Shape hitbox){
       return bottomHitbox.intersects(hitbox) || topHitbox.intersects(hitbox);
    }
}
