package de.bgy21.evolution_ai.ui.screens;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;


public class BallState extends BasicGameState {

    public static int ID = 0;
    public ArrayList<Shape> balls = new ArrayList<>();
    public Shape player;
    private int playerSize = 10;
    protected float movementSpeed = 3f;
    protected float accelaration = 1f * 10;
    float fallSpeed = -0.25f;
    Random random = new Random(404);
    Vector2f movementInput = new Vector2f();
    Vector2f playerVel = new Vector2f();


    @Override
    public int getID() {
        return ID;
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

        player = new Circle((float)(gameContainer.getWidth() / 2.0), gameContainer.getHeight() / 2, 10);

        Input input = gameContainer.getInput();
        input.addKeyListener(new PlayerInputs());
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(new Color(Color.white));
        balls.forEach(graphics::fill);
        graphics.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        graphics.fill(player);
       //
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        for (int j = 0; j < balls.size(); j++) {
            Shape ball = balls.get(j);

            ball.setCenterY(((float) (ball.getCenterY() - fallSpeed )));
            if (ball.intersects(player)){
                this.balls.remove(ball);
                this.spawnRandomBall(gameContainer.getWidth());
                fallSpeed -= 0.1f;
                playerSize += 10;
                player = new Circle(player.getCenterX(), player.getCenterY(), playerSize);
            }
            if (ball.getCenterY() - ball.getHeight() > gameContainer.getHeight()) {
                this.balls.remove(ball);
                this.spawnRandomBall(gameContainer.getWidth());
            }

        }

        movePlayer();

        Input input = gameContainer.getInput();
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }
    }

    private void spawnRandomBall(int gameWidth) {
        float randomHeight = this.random.nextInt() % 110 + 10;
        this.balls.add(new Ellipse(random.nextInt() % gameWidth, 0 - randomHeight, randomHeight, randomHeight));
    }

    void movePlayer(){
        float addSpeed = movementInput.dot(playerVel) - accelaration;
        if(addSpeed < 0){
            addSpeed = 0;
        }
        player.setCenterY(player.getCenterY() + movementInput.y * movementSpeed);
        player.setCenterX(player.getCenterX() + movementInput.x * movementSpeed);
    }

    class PlayerInputs implements KeyListener{

        @Override
        public void keyPressed(int i, char c) {
            System.out.println(i);
            switch(i){
                case Input.KEY_UP:
                    movementInput.y += -1;
                    break;
                case  Input.KEY_DOWN:
                    movementInput.y += 1;
                    break;
                case Input.KEY_RIGHT:
                    movementInput.x += 1;
                    break;
                case Input.KEY_LEFT:
                    movementInput.x += -1;
            }
        }



        @Override
        public void keyReleased(int i, char c) {
            System.out.println(i);
            switch(i){
                case Input.KEY_UP:
                    movementInput.y += 1;
                    break;
                case  Input.KEY_DOWN:
                    movementInput.y -= 1;
                    break;
                case Input.KEY_RIGHT:
                    movementInput.x -= 1;
                    break;
                case Input.KEY_LEFT:
                    movementInput.x += 1;
            }
        }

        @Override
        public void setInput(Input input) {

        }

        @Override
        public boolean isAcceptingInput() {
            return true;
        }

        @Override
        public void inputEnded() {

        }

        @Override
        public void inputStarted() {

        }
    }

}

