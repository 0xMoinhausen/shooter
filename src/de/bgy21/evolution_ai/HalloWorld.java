package de.bgy21.evolution_ai;
import java.io.IOException;
import java.util.Random;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class HalloWorld extends BasicGame {

    private Shape oval;
    private int hitCount = 0;
    private Image image;

    public HalloWorld() {
        super("Hallo World");
    }

    public static void main(String[] args) throws SlickException, IOException {
        AppGameContainer container = new AppGameContainer(new HalloWorld());
        container.setDisplayMode(800, 600, false);

        double[] xData = new double[] { 0.0, 1.0, 9.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };

// Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

// Show it
        new SwingWrapper(chart).displayChart();

// Save it
        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG);

// or save it in high-res
        BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300);
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
