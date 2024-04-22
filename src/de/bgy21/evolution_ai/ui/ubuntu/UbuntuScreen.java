package de.bgy21.evolution_ai.ui.ubuntu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Random;

public class UbuntuScreen extends BasicGameState {

    private ArrayList<UbuntuLogo> logos = new ArrayList<>();
    private Random random = new Random();

    @Override
    public int getID() {
        return 9;
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        container.setTargetFrameRate(60);
        super.enter(container, game);
        for (int i = 0; i < 9; i++) {
            logos.add(new UbuntuLogo(UbuntuLogoSize.Big, random, container));
        }
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        logos.forEach(ubuntuLogo -> ubuntuLogo.render(graphics, gameContainer));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        logos.forEach(ubuntuLogo -> ubuntuLogo.update(i, gameContainer));
    }
}
