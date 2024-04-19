package de.bgy21.evolution_ai.ui.screens.flappybird;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Pipes {
    static Image pipeSprite;

    static {
        try {
            pipeSprite = new Image("assets/flappybird/sprites/pipe-red.png").getScaledCopy(1.5f);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    private int posX, gapY, gapSize;
    private float speedX, pipeMoveSpeed;
    private Shape bottomHitbox, topHitbox;

    public Pipes(){
        posX = 400;
        gapY = 100;
        gapSize = 120;
        speedX = 10f;
        pipeMoveSpeed = 0.09f;
        topHitbox = new Rectangle(posX, gapY - gapSize/2, pipeSprite.getWidth(), -pipeSprite.getHeight());
        bottomHitbox = new Rectangle(posX, gapY + gapSize/2, pipeSprite.getWidth(), pipeSprite.getHeight());
    }

    public void render(Graphics graphics){
        graphics.draw(topHitbox);
        graphics.draw(bottomHitbox);

        graphics.drawImage(pipeSprite, posX, gapY + gapSize / 2);
        graphics.rotate(posX + pipeSprite.getWidth() / 2, gapY, 180);
        graphics.drawImage(pipeSprite, posX, gapY + gapSize / 2);
        graphics.rotate(posX + pipeSprite.getWidth() / 2, gapY, -180);
    }

    public void update(float delta){
        speedX = pipeMoveSpeed * delta;
        posX -= speedX;
        if(posX <= 0){
            posX = Display.getWidth();
        }
        topHitbox.setLocation(posX, gapY - gapSize/2);
        bottomHitbox.setLocation(posX, gapY + gapSize/2);
        //posX = posX % Display.getWidth();
    }

    public boolean colliding(Shape hitbox){
       return bottomHitbox.intersects(hitbox) || topHitbox.intersects(hitbox);
    }
}
