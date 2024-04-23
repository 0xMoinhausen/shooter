package de.bgy21.evolution_ai.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class DebugClass {
    final KeyListener keyListener;

    public DebugClass(GameContainer container){
        keyListener = new DebugKeys(container);
    }
    class DebugKeys implements KeyListener{

        final GameContainer container;
        DebugKeys(GameContainer container){
            this.container = container;
        }
        @Override
        public void keyPressed(int keyID, char c) {
            if(keyID == Input.KEY_ESCAPE){
                container.exit();
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
