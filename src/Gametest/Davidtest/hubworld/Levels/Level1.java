package Gametest.Davidtest.hubworld.Levels;

import Gametest.Davidtest.hubworld.entities.Entity;
import Gametest.Davidtest.hubworld.gfx.Screen;
import Gametest.Davidtest.hubworld.Levels.tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level1 {

    private byte[] tiles; //an ArrayList for where the tiles are
    public int width;
    public int height;
    public List<Entity> entities = new ArrayList<Entity>();

    public Level1 (int width, int height) {
        tiles = new byte[width*height];
        this.width = width;
        this.height = height;
        this.generateLevel();
    }

    public void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x * y % 10 < 5) {
                    tiles[x + y * width] = Tile.GRASS.getId();
                } else {
                    tiles[x + y * width] = Tile.STONE.getId();
                }
            }
        }
    }

    public void tick() {
        for (Entity e : entities) {
            e.tick();
        }
    }
    //assigns players position on the screen
    public void renderTiles(Screen screen, int xOffset, int yOffset) {
        if (xOffset < 0) xOffset = 0;
        if (xOffset > ((width << 3) - screen.width)) xOffset = ((width << 3) - screen.width);
        if (yOffset < 0) yOffset = 0;
        if (yOffset > ((height << 3) - screen.height)) yOffset = ((height << 3) - screen.height);

        screen.setOffset(xOffset, yOffset);

        for(int y = 0; y < height;y++) {
            for (int x = 0; x < width; x++) {
                getTile(x,y).render(screen,this,x << 3, y << 3);
            }
        }
    }
    //render the entities/mobs above the tiles so they wll be visible
    public void renderEntities(Screen screen) {
        for (Entity e : entities) {
            e.render(screen);
        }
    }
    private Tile getTile (int x, int y) {
        if (x < 0 || x > width || y > height) return  Tile.VOID;
        return Tile.tiles[tiles[x + y * width]];
    }
    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }
}
