package de.bgy21.evolution_ai.ui.screens.flappybird;


import de.bgy21.evolution_ai.activation_functions.Linear;
import de.bgy21.evolution_ai.activation_functions.Sigmoid;
import de.bgy21.evolution_ai.neuralnetwork.NeuralNetwork;
import de.bgy21.evolution_ai.neuralnetwork.layer.InputLayer;
import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.Random;

public class FlappyBirdInstance {
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
        this.container = container;
        this.graphics = container.getGraphics();
        this.birds = new ArrayList<>();
        for (int i = 0; i < birdAmount; i++) {
            NeuralNetwork neuralNetwork = new NeuralNetwork(new InputLayer(1));
            neuralNetwork.add_hidden_layer(5, NeuralNetwork.randomWeights( 5, random), new Linear());
            neuralNetwork.add_hidden_layer(1, NeuralNetwork.randomWeights( 5, random), new Sigmoid());
            birds.add(new BirdCharacter(neuralNetwork));
            System.out.println("Created Bird!");
        }
        this.pipes = new Pipes[pipesAmount];
        for (int i = 0; i < pipesAmount; i++) {
            this.pipes[i] = new Pipes();
            System.out.println("Created Pipe!");
        }
    }

    public FlappyBirdInstance(GameContainer container, int pipesAmount, ArrayList<BirdCharacter> birds) {
        this.container = container;
        this.graphics = container.getGraphics();
        this.pipes = new Pipes[pipesAmount];
        for (int i = 0; i < pipesAmount; i++) {
            this.pipes[i] = new Pipes();
            System.out.println("Created Pipe!");
        }
        this.birds = birds;
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
        for (int i = 0; i < this.birds.size(); i++) {
            BirdCharacter bird = this.birds.get(i);
            bird.update(delta);
            if (bird.posY < 0 || bird.posY > container.getHeight()) {
                bird.killBird(container.getInput());
                this.deathBirds.add(bird);
                this.birds.remove(i);
                continue;
            }
            for (Pipes pipe : pipes) {
                if(pipe.colliding(bird.birdHitbox)){
                    bird.killBird(container.getInput());
                    this.deathBirds.add(bird);
                    this.birds.remove(i);
                }
            }
        }
        for (Pipes pipe : pipes) {
           pipe.update(delta);
        }
    }
}
