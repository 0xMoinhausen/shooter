package de.bgy21.evolution_ai.ui.ubuntu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.Texture;

import java.util.Random;

public class UbuntuLogo {
    public final static Image BigUbuntu;
    static {
        try {
            BigUbuntu = new Image("assets/ballgame/sprites/redcircle.png");
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    private Image texture;
    private Vector2f position;
    private Vector2f speed;

    public UbuntuLogo(UbuntuLogoSize size, Random random, GameContainer container) {
        this.speed = new Vector2f((float) (random.nextFloat() - 0.5), (float) (random.nextFloat() - 0.5));
        this.position = new Vector2f(random.nextInt(container.getWidth()), random.nextInt(container.getHeight()));
        this.texture = BigUbuntu;
    }

    public void update(int delta, GameContainer container) {
        position.add(speed.scale(0.5));
        texture.rotate( 1 );
    }

    public void render(Graphics graphics, GameContainer container) {
        graphics.drawImage(texture, position.x , position.y);
    }
}
