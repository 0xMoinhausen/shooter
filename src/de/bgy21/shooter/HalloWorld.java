package de.bgy21.shooter;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class HalloWorld extends BasicGame {

    private Shape oval;
    private int hitCount = 0;
    private Image image;

    public HalloWorld() {
        super("Hallo World");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new HalloWorld());
        container.setDisplayMode(800, 600, false);
        container.start();
    }

    @Override
    public void render(GameContainer container, Graphics g)
            throws SlickException {
        g.fill(oval);
        g.drawString("Hallo World " + hitCount, 100, 100);
        g.drawImage(image, 300, 50);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        oval = new Ellipse(200, 200, 100, 25);
        image = new Image("testdata/logo.png");
    }

    @Override
    public void update(GameContainer container, int delta)
            throws SlickException {
        image.rotate(0.02f);
        Input input = container.getInput();

        //Maus Taste1 abfragen und auf Kollision mit Oval testen
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            Random random = new Random();
            int mouseX = input.getMouseX();
            int mouseY = input.getMouseY();
            if (oval.contains(mouseX, mouseY)) {
                hitCount++;
                oval.setLocation(random.nextInt(container.getWidth()), random.nextInt(container.getHeight()));
            }

            //Fenster mit ESC sclie�en
        }else if(input.isKeyPressed(Input.KEY_ESCAPE)){
            container.exit();
        }
    }
}
