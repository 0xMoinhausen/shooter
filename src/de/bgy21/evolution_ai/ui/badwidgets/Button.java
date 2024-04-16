package de.bgy21.evolution_ai.ui.badwidgets;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class Button<T extends Shape> {
    private T shape;
    private Color color;
    public String content;


    public Button(T shape, Color color, String content) {
        this.shape = shape;
        this.color = color;
        this.content = content;
    }

    public void update(GameContainer gameContainer, Runnable action) {
        Input input = gameContainer.getInput();
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON) && shape.contains(input.getMouseX(), input.getMouseY())) {
            action.run();
        }

    }

    public void render(GameContainer gameContainer, Graphics graphics) {
        Color lastColor = graphics.getColor();
        graphics.setColor(this.color);
        graphics.fill(shape);
        graphics.setColor(Color.white);
        graphics.drawString(content, shape.getX(), shape.getY());
        graphics.setColor(lastColor);
    }

    public void setPosition(Vector2f pos) {
        this.shape.setLocation(pos);
    }

    public void setSize(Vector2f size) {
        this.shape.setX(size.x);
        this.shape.setY(size.y);
    }
}
