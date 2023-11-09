package de.bgy21.shooter.raycasting;

import de.bgy21.shooter.map.Map;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class World {

    private Map map;
    private Vector2f playerPos;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void update() {
        
    }
    public void render(GameContainer gameContainer, Graphics graphics) {

    }
}
