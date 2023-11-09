package de.bgy21.shooter;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SlickException{
        // initially the container is set to null.We will add properties later
        AppGameContainer screen = null;
        screen = new AppGameContainer(new Game());
        screen.setDisplayMode(600, 400, false);
        screen.start();
    }
}