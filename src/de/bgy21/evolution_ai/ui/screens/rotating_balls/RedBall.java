package de.bgy21.evolution_ai.ui.screens.rotating_balls;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

public class RedBall {
    static Random random = new Random();
    private Image redBallSprite;
    private final int redballSizeX, redBallSizeY;
    private float scale;
    private float rotation;
    private float posX, posY;
    private float speedX, speedY, rotationSpeed;
    static float GRAVITY = 1f;

    public RedBall(Image redBallSprite, int rotation, int posX, int posY) {
        this.redBallSprite = redBallSprite;
        this.rotation = rotation;
        this.posX = posX;
        this.posY = posY;

        scale = random.nextFloat() + 0.5f;

        redballSizeX = redBallSprite.getWidth();
        redBallSizeY = redBallSprite.getHeight();

        rotationSpeed = 1f;
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics){
        graphics.scale(scale , scale);
        graphics.rotate(posX + redballSizeX/2.0f, posY + redBallSizeY/2.0f, rotation);
        graphics.drawImage(redBallSprite, posX, posY);
        graphics.scale(1 , 1);
        graphics.rotate(posX + redballSizeX/2.0f, posY + redBallSizeY/2.0f, -rotation);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta){
        speedY = GRAVITY;
        posY += speedY * delta;

        rotation += rotationSpeed * delta;

        if(posY - redBallSizeY > gameContainer.getHeight()){
            posY = 0 - redBallSizeY;
            posX = random.nextInt(gameContainer.getWidth());
            scale = random.nextFloat() + 0.5f;
        }
    }
}
