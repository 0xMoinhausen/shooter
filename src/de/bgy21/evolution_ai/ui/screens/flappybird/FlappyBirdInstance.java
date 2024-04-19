package de.bgy21.evolution_ai.ui.screens.flappybird;


import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public class FlappyBirdInstance {
    private final GameContainer container;
    private final Graphics graphics;

    private final BirdCharacter[] birds;
    private final Pipes[] pipes;

    FlappyBirdInstance(
            GameContainer container,
            int birdAmount,
            int pipesAmount
    ){
        this.container = container;
        this.graphics = container.getGraphics();
        this.birds = new BirdCharacter[birdAmount];
        for (int i = 0; i < birdAmount; i++) {
            birds[i] = new BirdCharacter(container.getInput());
            System.out.println("Created Bird!");
        }
        this.pipes = new Pipes[pipesAmount];
        for (int i = 0; i < pipesAmount; i++) {
            this.pipes[i] = new Pipes();
            System.out.println("Created Pipe!");
        }
    }

    public void render(){
        for (BirdCharacter bird : this.birds) {
            bird.render(graphics);
        }
        for (Pipes pipe : pipes) {
           pipe.render(graphics);
        }
    }

    public void update(int delta) {
        for (BirdCharacter bird : birds) {
           bird.update(delta);
            for (Pipes pipe : pipes) {
                if(pipe.colliding(bird.birdHitbox)){
                    bird.killBird(container.getInput());
                }
            }
        }
        for (Pipes pipe : pipes) {
           pipe.update(delta);
        }
    }
}
