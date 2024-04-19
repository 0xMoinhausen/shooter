package de.bgy21.evolution_ai.ui.screens.flappybird;

import de.bgy21.evolution_ai.ui.world.Block;
import de.bgy21.evolution_ai.ui.world.Grid;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameScreen extends BasicGameState {

    public static int ID = 4;
    private static int flappyBirdInstancesAmount = 1;
    private FlappyBirdInstance[] flappyBirdInstances = new FlappyBirdInstance[flappyBirdInstancesAmount];

    @Override
    public int getID() {
        return ID;
    }


    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        for (FlappyBirdInstance flappyBirdInstance : flappyBirdInstances) {
            flappyBirdInstance = new FlappyBirdInstance();
        }

    }
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }
    }
}
