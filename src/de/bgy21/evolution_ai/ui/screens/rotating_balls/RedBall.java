package de.bgy21.evolution_ai.ui.screens.rotating_balls;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class RedBall {
    private Image redBallSprite;
    private final int redballSizeX, redBallSizeY;
    private float rotation;
    private float posX, posY;
    private float speedX, speedY, rotationSpeed;
    static float GRAVITY = 1f;

    public RedBall(Image redBallSprite, int rotation, int posX, int posY) {
        this.redBallSprite = redBallSprite;
        this.rotation = rotation;
        this.posX = posX;
        this.posY = posY;

        redballSizeX = redBallSprite.getWidth();
        redBallSizeY = redBallSprite.getHeight();

        rotationSpeed = 1f;
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics){
        graphics.rotate(posX, posY, rotation);
        graphics.scale();
        graphics.drawImage(redBallSprite, posX, posY);
        graphics.rotate(posX, posY, -rotation);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta){
        speedY = GRAVITY;
        posY += speedY * delta;

        rotation += rotationSpeed * delta;
    }
}
