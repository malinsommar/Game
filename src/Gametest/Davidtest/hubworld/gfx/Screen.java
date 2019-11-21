package Gametest.Davidtest.hubworld.gfx;

public class Screen {
    public static final int MAP_WIDTH = 64;
    public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;

    public int[] pixels;
    //public int[] tiles = new int[MAP_WIDTH*MAP_WIDTH]; //designate tiles
    //public int[] colours = new int[MAP_WIDTH*MAP_WIDTH * 4]; //Holds information about the bits of data about which color is where

    public int xOffset = 0;
    public int yOffset = 0; //Offset the screen and give a "cameraPoint"

    public int width;
    public int height;

    public SpriteSheet sheet; //move the sheet to make it local with the screen. That way there can be multiple screens


    public Screen(int width, int height, SpriteSheet sheet) {
        //setting the variables
        this.width = width;
        this.height = height;
        this.sheet = sheet;

        pixels = new int[width * height];
    }
    //render the tiles and colours
    public void render(int xPos, int yPos, int tile, int colour) {
        xPos -= xOffset;
        yPos -= yOffset;

        int xTile = tile % 32;
        int yTile = tile / 32;
        int tileOffset = (xTile << 3) + (yTile << 3) * sheet.width;
        for (int y = 0; y < 8; y++) {
            if (y + yPos < 0 || y + yPos >= height) continue;
            int ySheet = y;
            for (int x = 0; x < 8; x++) {
                if (x + xPos < 0 || x + xPos >= width) continue;
                int xSheet = x;
                int col = (colour >> (sheet.pixels[xSheet + ySheet * sheet.width + tileOffset] * 8)) & 255;
                if (col < 255) pixels[(x+xPos) + (y+yPos) * width] = col;
            }
        }
    }
}

