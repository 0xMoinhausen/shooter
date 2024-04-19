package de.bgy21.evolution_ai.ui.badwidgets;

import org.lwjgl.Sys;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;

public class Button<T extends Shape> {
    private T shape;
    private Color color;
    public String content;
    private Runnable action;

    public Button(T shape, Color color, String content, Runnable action, Input input) {
        this.shape = shape;
        this.color = color;
        this.content = content;
        this.action = action;
        input.addMouseListener(new ButtonListener());
    }

    public void update(GameContainer gameContainer, Runnable action) {
        Input input = gameContainer.getInput();
        //System.out.println("\033\143");
        //System.out.println("Maus:" +  input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON));
        //System.out.println("input mouse:" +  input.getMouseX());
        //System.out.println("input mouse:" +  input.getMouseY());
        //System.out.println("contains: " +  shape.contains(input.getMouseX(), input.getMouseY()));

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && shape.contains(input.getMouseX(), input.getMouseY())) {
            action.run();
        }

    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        Color lastColor = graphics.getColor();
        graphics.setColor(this.color);
        graphics.fill(shape);
    }

    class ButtonListener implements MouseListener{

        @Override
        public void mouseWheelMoved(int i) {

        }

        @Override
        public void mouseClicked(int i, int i1, int i2, int i3) {
            //System.out.println(i);
        }

        @Override
        public void mousePressed(int i, int mouseX, int mouseY) {
            if(i == Input.MOUSE_LEFT_BUTTON){
                if (shape.contains(mouseX, mouseY)) {
                    action.run();
                }
            }
        }

        @Override
        public void mouseReleased(int i, int i1, int i2) {

        }

        @Override
        public void mouseMoved(int i, int i1, int i2, int i3) {

        }

        @Override
        public void mouseDragged(int i, int i1, int i2, int i3) {

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
