package de.bgy21.evolution_ai.ui.screens.flappybird;

import de.bgy21.evolution_ai.ui.world.Block;
import de.bgy21.evolution_ai.ui.world.Grid;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
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
        // Bird amount muss mal 0.8 und mal 0.2 eine gerade zahl rauskommen weil ich nicht coden kann
        flappyBirdGame = new FlappyBirdInstance(container,50, 1, random);
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
        if (flappyBirdGame.birds.isEmpty()) {
            ArrayList<BirdCharacter> deathBirds = this.flappyBirdGame.deathBirds;
            ArrayList<BirdCharacter> birds = new ArrayList<>(deathBirds.size());
            for (int j = 0; j < 5; j++) {
                for (int i = (int) (deathBirds.size() * 0.8) ; i < deathBirds.size(); i++) {
                    System.out.println(i);
                    try {
                        birds.add(deathBirds.get(i).clone(this.random, 0.4));
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            this.flappyBirdGame = new FlappyBirdInstance(gameContainer, 1,birds);
        }
        System.out.println("Flappys: " + flappyBirdGame.birds.size());
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            gameContainer.exit();
        }
    }
}
