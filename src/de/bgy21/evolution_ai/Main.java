package de.bgy21.evolution_ai;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SlickException {

        ScalableGame s = new ScalableGame(new Game(), 1920, 1080, false);

        AppGameContainer screen  = new AppGameContainer(s);
        screen.setDisplayMode(screen.getScreenWidth()-100 , (screen.getScreenHeight() -100), false);
        screen.start();




    }
}