package de.bgy21.shooter;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

class NodePos {
    public int posX, posY;

    public NodePos(int posX, int posY) {
        super();
        this.posX = posX;
        this.posY = posY;
    }

}

class NodeIO {
    private String dataType;
    private String name;


    public NodeIO(String dataType, String name) {
        this.dataType = dataType;
        this.name = name;
    }
}

class NodeWidget{


    private NodePos pos;
    private String nodeName;
    private NodeIO[] inputs;
    private NodeIO[] outputs;

    private boolean clicked;

    public int height, width;

    public NodeWidget(NodePos pos, String nodeName, NodeIO[] inputs, NodeIO[] outputs) {
        super();
        this.pos = pos;
        this.nodeName = nodeName;
        this.inputs = inputs;
        this.outputs = outputs;

        height = 100;
        width = nodeName.length() * 10;
    }

    public void render(GameContainer container, Graphics g)
            throws SlickException {
        //g.fillRect(pos.posX, pos.posY, nodeName.length() * 100 , Math.max(inputs.length, outputs.length) + 100, new Image("testdata/logo.png"), 0, 0);
        g.drawRect(pos.posX, pos.posY, nodeName.length() * 10 , 100);
        g.drawString(nodeName, pos.posX, pos.posY);
        for (int i = 0; i < inputs.length; i++){
            g.drawRect(pos.posX, pos.posY + i * 10 + 20, 10, 10);
        }

    }

    public boolean clicked (int mouseX, int mouseY) {
        if(
                mouseX > pos.posX &&
                        mouseX < pos.posX + width &&
                        mouseY > pos.posY &&
                        mouseY < pos.posY + height
        ) {
            clicked = true;
            return true;
        } else {
            clicked = false;
            return false;
        }
    }

    public void moveWindow (int posX, int posY) {
        if(clicked) {
            pos.posX = posX;
            pos.posY = posY;
        }

    }
}