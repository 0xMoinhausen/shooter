package de.bgy21.evolution_ai;
import de.bgy21.evolution_ai.ui.states.BallState;
import de.bgy21.evolution_ai.ui.states.GameState;
import de.bgy21.evolution_ai.ui.states.MainMenuState;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

    public Game() {
        super("EvolutionAi");
        Display.setResizable(true);
    }


    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
      //  this.addState(new BallState());
        this.addState(new GameState());
        this.addState(new MainMenuState());
    }


}
