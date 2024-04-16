package de.bgy21.evolution_ai;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SlickException{

        AppGameContainer screen = new AppGameContainer(new Game());
        screen.setDisplayMode(1920, 1080, false);
        screen.start();


    }
}