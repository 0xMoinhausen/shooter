package de.bgy21.evolution_ai.ui.screens.flappybird;


import de.bgy21.evolution_ai.activation_functions.Linear;
import de.bgy21.evolution_ai.activation_functions.Sigmoid;
import de.bgy21.evolution_ai.activation_functions.TanH;
import de.bgy21.evolution_ai.neuralnetwork.NeuralNetwork;
import de.bgy21.evolution_ai.neuralnetwork.layer.InputLayer;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.Random;

public class FlappyBirdInstance {
    static float scaleMult = 1.5f;
    private final GameContainer container;
    private final Graphics graphics;

    public ArrayList<BirdCharacter> birds;
    private final Pipes[] pipes;
    public ArrayList<BirdCharacter> deathBirds = new ArrayList<>();

    public FlappyBirdInstance(
            GameContainer container,
            int birdAmount,
            int pipesAmount,
            Random random
    ){
        pipesAmount = Math.min(2, pipesAmount); //Max 2 Pipes
        this.container = container;
        this.graphics = container.getGraphics();
        this.birds = new ArrayList<>();
        for (int i = 0; i < birdAmount; i++) {
            NeuralNetwork neuralNetwork = new NeuralNetwork(new InputLayer(2));
            neuralNetwork.add_hidden_layer(3, NeuralNetwork.randomWeights( 6, random), new TanH());
            neuralNetwork.add_hidden_layer(1, NeuralNetwork.randomWeights( 3, random), new Sigmoid());
            birds.add(new BirdCharacter(neuralNetwork));
            System.out.println("Created Bird!");
        }
        this.pipes = new Pipes[pipesAmount];
        for (int i = 0; i < pipesAmount; i++) {
            this.pipes[i] = new Pipes(i * 500);
            System.out.println("Created Pipe!");
        }
    }

    public FlappyBirdInstance(GameContainer container, int pipesAmount, ArrayList<BirdCharacter> birds) {
        this.container = container;
        this.graphics = container.getGraphics();
        this.pipes = new Pipes[pipesAmount];
        for (int i = 0; i < pipesAmount; i++) {
            this.pipes[i] = new Pipes(400 + i*200);
            System.out.println("Created Pipe!");
        }
        this.birds = birds;
    }

    public void render(){

        graphics.scale((Display.getWidth() + 0.0f)  / container.getWidth() * scaleMult,  (Display.getHeight() + 0.0f) / container.getHeight() * scaleMult);

        graphics.translate( 1, 1);
        System.out.println(Display.getWidth() / container.getWidth());
        for (BirdCharacter bird : this.birds) {
            bird.render(graphics);
        }
        for (Pipes pipe : pipes) {
           pipe.render(graphics);
        }
    }

    public void update(int delta) {
        for (int i = 0; i < this.birds.size(); i++) {
            if (this.birds.size() <= 1) {
                System.out.println(this.birds.get(0));
            }
            BirdCharacter bird = this.birds.get(i);
            bird.update(delta, container, pipes[0].gapY);
            if (bird.posY < 0 || bird.posY > container.getHeight()) {
                bird.killBird(container.getInput());
                this.deathBirds.add(bird);
                this.birds.remove(i);
                i -= 1;
                continue;
            }
            for (Pipes pipe : pipes) {
                if(pipe.colliding(bird.birdHitbox)){
                    bird.killBird(container.getInput());
                    this.deathBirds.add(bird);
                    this.birds.remove(i);
                    i -= 1;
                }
            }
        }
        for (Pipes pipe : pipes) {
           pipe.update(delta, container);
        }
    }
}
