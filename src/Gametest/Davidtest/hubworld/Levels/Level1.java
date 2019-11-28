package Gametest.Davidtest.hubworld.Levels;

import Gametest.Davidtest.hubworld.entities.Entity;
import Gametest.Davidtest.hubworld.gfx.Screen;
import Gametest.Davidtest.hubworld.Levels.tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

//Build the first map around everything in the Tile-class
public class Level1 {

    private byte[] tiles; //an ArrayList for where the tiles are
    public int width;
    public int height;
    public List<Entity> entities = new ArrayList<Entity>();
    private String imagePath;
    private BufferedImage image;

    //Assign all the variables in the constructor
    public Level1 (String imagePath) {
        if (imagePath != null) {
            this.imagePath = imagePath;
            this.loadLevelFromFile();
        } else {
            this.width = 64;
            this.height = 64;
            tiles = new byte[width * height];
            this.generateLevel();
        }
    }

    private void loadLevelFromFile() {
        try {
            this.image = ImageIO.read(Level1.class.getResource(this.imagePath));
            this.width = image.getWidth();
            this.height = image.getHeight();
            tiles = new byte[width* height];
            this.loadTiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads the tiles from the image
    private void loadTiles() {
        //translate the image data into an int-array
        int[] tileColours = this.image.getRGB(0,0,width,height,null,0,width);
        //loops through both the x and y-tiles until they reach the images max-value of 64
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //loop through all the possible tiles located in the "tiles"-variable
                tileCheck: for (Tile t : Tile.tiles) {
                    if(t != null && t.getLevelColour() == tileColours[x + y * width]) {
                        this.tiles[x + y * width] = t.getId();
                        break tileCheck;
                    }
                }
            }
        }
    }

    private void saveLevelToFile() {
        try {
            ImageIO.write(image, "png", new File(Level.class.getResource(this.imagePath).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void alterTile(int x, int y, Tile newTile) {
        this.tiles[x+y*width] = newTile.getId();
        image.setRGB(x,y,newTile.getLevelColour());
    }
    //Generate the tiles into the level
    public void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x * y % 10 < 7) {
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
    public Tile getTile (int x, int y) {
        if (0 > x || x >= width || 0 > y || y >= height)
            return  Tile.VOID;
        return Tile.tiles[tiles[x + y * width]];
    }
    public void addEntity(Entity entity) {
        this.entities.add(entity); //call the Entity-class into the Level-class by adding the Player-object into Level-object
    }
}