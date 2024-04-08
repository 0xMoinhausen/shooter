package de.bgy21.evolution_ai.ui.states;

import org.knowm.xchart.style.markers.Oval;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;


public class BallState extends BasicGameState {

    public ArrayList<Shape> balls = new ArrayList<>();;
    double fallSpeed = -1;
    Random random = new Random(404);

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void enter(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.balls.add( new Ellipse(0, 0, 30, 30));
        this.balls.add( new Ellipse(100, 100, 30, 30));
        this.balls.add( new Ellipse(0, 0, 30, 30));
        this.balls.add( new Ellipse(100, 100, 30, 30));
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        balls.forEach(graphics::fill);
       // graphics.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        for (int j = 0; j < balls.size(); j++) {
            Shape ball = balls.get(j);

            ball.setCenterY((int)(ball.getCenterY() - fallSpeed ));
            if (ball.getCenterY() - ball.getHeight() > gameContainer.getHeight()) {
                this.balls.remove(ball);
                this.spawnRandomBall(gameContainer.getWidth());
            }

        }

    }

    private void spawnRandomBall(int gameWidth) {
        float randomHeight = this.random.nextInt() % 110 + 10;
        this.balls.add(new Ellipse(random.nextInt() % gameWidth, 0 - randomHeight, randomHeight, randomHeight));
    }
}
