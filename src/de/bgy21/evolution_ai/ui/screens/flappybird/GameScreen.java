package de.bgy21.evolution_ai.ui.screens.flappybird;

import de.bgy21.evolution_ai.ui.world.Block;
import de.bgy21.evolution_ai.ui.world.Grid;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

public class GameScreen extends BasicGameState {

    public static float speedMult = 1;
    public static int ID = 4;
    private FlappyBirdInstance flappyBirdGame;
    private Random random = new Random(64);

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        flappyBirdGame = new FlappyBirdInstance(container,50, 2, random);
        //
    }
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        flappyBirdGame.render();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        delta *= speedMult;
        Input input = gameContainer.getInput();
        flappyBirdGame.update(delta);
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }
    }
}
