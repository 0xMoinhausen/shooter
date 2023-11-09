package de.bgy21.shooter;
import de.bgy21.shooter.states.GameState;
import de.bgy21.shooter.states.MainMenuState;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

    public Game() {
        super("Shooter");
        Display.setResizable(true);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new GameState());
        this.addState(new MainMenuState());
    }

}
