package de.bgy21.evolution_ai.ui.screens;

import de.bgy21.evolution_ai.ui.badwidgets.Button;
import de.bgy21.evolution_ai.ui.screens.flappybird.GameScreen;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

    Button<Rectangle> ballStateButton;
    Button<Rectangle> flappyBirdButton;

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        super.enter(container, game);
        ballStateButton = new Button<>(new Rectangle(100, 100, 400, 90), Color.gray, "Ball Game");
        flappyBirdButton = new Button<>(new Rectangle(100, 200, 400, 90), Color.black, "Flappy Game");
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        ballStateButton.render(gameContainer, graphics);
        flappyBirdButton.render(gameContainer, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        flappyBirdButton.update(gameContainer, () -> stateBasedGame.enterState(BallState.ID));
        //ballStateButton.update(gameContainer, () -> stateBasedGame.enterState(BallState.ID));
        //flappyBirdButton.update(gameContainer, () -> stateBasedGame.enterState(BallState.ID));
    }
}
