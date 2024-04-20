package de.bgy21.evolution_ai.ui.screens.flappybird;

import de.bgy21.evolution_ai.activation_functions.Sigmoid;
import de.bgy21.evolution_ai.neuralnetwork.NeuralNetwork;
import de.bgy21.evolution_ai.neuralnetwork.layer.InputLayer;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class BirdCharacter {

    static Image birdSprite;

    static float gravity = 0.02f;
    static float jumpForce = 7.5f;
    static {
        try {
            birdSprite = new Image("assets/flappybird/sprites/bluebird-midflap.png").getScaledCopy(1.5f);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    public int posX, posY;
    private float speedY;
    private NeuralNetwork neuralNetwork;
    public boolean isDead = false;
    Shape birdHitbox = new Circle(0, 0, birdSprite.getHeight()/ 2);

    //final KeyListener birdInput = new BirdInput();

    public BirdCharacter(NeuralNetwork neuralNetwork){
        posX = 200;
        posY = 100;
        speedY = 0;
        //input.addKeyListener(birdInput);
        this.neuralNetwork = neuralNetwork;
    }

    public void render(Graphics graphics){
        graphics.rotate(posX + birdSprite.getWidth() / 2, posY + birdSprite.getHeight() / 2, speedY * 2);
        graphics.drawImage(birdSprite, posX, posY);
        graphics.draw(birdHitbox);
        graphics.rotate(posX + birdSprite.getWidth() / 2, posY + birdSprite.getHeight() / 2, -speedY * 2);
    }

    public void update(float delta){
        speedY += gravity * delta;
        posY += speedY;
        birdHitbox.setLocation(posX, posY);
        neuralNetwork.inputLayer.getNeuron(0).setValue(posY);
        if (neuralNetwork.lastLayer().getNeuron(0).getValue() >= 0.5) {
            jump();
        }
    }

    public void jump(){
        speedY = -jumpForce; //- weil hoc
    }

    public void killBird(Input input){
        this.isDead = true;
        //input.removeKeyListener(birdInput);
    }

    public BirdCharacter clone(Random random, double mutateRate) throws CloneNotSupportedException {
        BirdCharacter bird = new BirdCharacter(this.neuralNetwork.clone(mutateRate, random));
        return bird;
    }


    class BirdInput implements KeyListener{

        @Override
        public void keyPressed(int input, char c) {
            if(input == Input.KEY_SPACE){
              jump();
            }
        }

        @Override
        public void keyReleased(int i, char c) {

        }

        @Override
        public void setInput(Input input) {

        }

        @Override
        public boolean isAcceptingInput() {
            return true;
        }

        @Override
        public void inputEnded() {

        }

        @Override
        public void inputStarted() {

        }
    }
}
