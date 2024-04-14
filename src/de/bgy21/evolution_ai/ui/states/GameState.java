package de.bgy21.evolution_ai.ui.states;

import de.bgy21.evolution_ai.ui.world.Block;
import de.bgy21.evolution_ai.ui.world.Grid;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {

    public Grid grid;
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        grid = new Grid(container.getHeight(), container.getWidth(), 90, 90);
        super.enter(container, game);

        grid.addGridObject(new Block(10, 10, 10, 10));

    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        grid.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        grid.update();
    }
}
