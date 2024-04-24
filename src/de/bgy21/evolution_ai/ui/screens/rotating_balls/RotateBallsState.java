package de.bgy21.evolution_ai.ui.screens.rotating_balls;

import de.bgy21.evolution_ai.ui.screens.BallState;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

public class RotateBallsState extends BasicGameState {
    static Image redCircleSprite;

    static {
        try {
            redCircleSprite = new Image("assets/ballgame/sprites/redcircle.png");
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    public static int ID = 5;
    public ArrayList<RedBall> balls = new ArrayList<>();
    Random random = new Random(404);

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.balls.add(new RedBall(redCircleSprite, 0, 100, 100));
        this.balls.add(new RedBall(redCircleSprite, 0, 300, 200));
        this.balls.add(new RedBall(redCircleSprite, 0, 500, 300));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        balls.forEach(ball -> {
            ball.render(gameContainer, stateBasedGame, graphics);
        });
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        balls.forEach(ball -> {
            ball.update(gameContainer, stateBasedGame, delta);
        });
    }

    private void spawnRandomBall(int gameWidth) {
    }

}

