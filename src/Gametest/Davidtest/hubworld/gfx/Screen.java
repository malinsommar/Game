package Gametest.Davidtest.hubworld.gfx;

public class Screen {
    public static final int MAP_WIDTH = 64;
    public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;

    public int[] tiles = new int[MAP_WIDTH*MAP_WIDTH]; //designate tiles
    public int[] colours = new int[MAP_WIDTH*MAP_WIDTH * 4]; //Holds information about the bits of data about which color is where

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

        //assign which colors will respond to what on the sheet
        for (int i = 0; i < MAP_WIDTH * MAP_WIDTH; i++) {
            colours[i * 4] = 0xff00ff; //black is pink
            colours[i * 4 + 1] = 0x00ffff; //light dark is light blue
            colours[i * 4 + 2] = 0xffff00; //gray is yellow
            colours[i * 4 + 3] = 0xffffff; //white is white
        }
    }
    //renders and loops all of the y and x-tiles.
    //keeps the y and x-axis within the screen-area.
    //corespondent with the Offset to let the game scroll up and down, left and right
    public void render (int[] pixels, int offset, int row) {

        for (int yTile = yOffset >> 3; yTile <= (yOffset + height) >> 3; yTile++) {
                  int yMin = yTile * 8 - yOffset; //minimum yTile shown on screen
                  int yMax = yMin + 8; //maximum yTile shown on screen
                  if (yMin < 0) yMin = 0; //locks so the minimum amount can't be lower than 0
                  if (yMax > height) yMax = height; //locks so the maximum can't be higher than the assigned height


                  for (int xTile = xOffset >> 3; xTile <= (xOffset + width) >> 3; xTile++) {
                      int xMin = xTile * 8 - xOffset; //minimum xTile shown on screen
                      int xMax = xMin + 8; // maximum xTile shown on screen
                      if (xMin < 0) xMin = 0; //locks so the minimum amount can't be lower than 0
                      if (xMax > width) xMax = width; //locks so the maximum can't be higher than the assigned width


                      int  tileIndex = (xTile & (MAP_WIDTH_MASK)) + (yTile & (MAP_WIDTH_MASK)) * MAP_WIDTH;

                      //draws out the pixels
                      for (int y = yMin; y < yMax; y++) {
                          int sheetPixel = ((y + yOffset) & 7) * sheet.width + ((xMin + xOffset) & 7);
                          int tilePixel = offset + xMin + y * row;
                          for (int x = xMin; x < xMax; x++) {
                              int colour = tileIndex * 4 + sheet.pixels[sheetPixel++];
                              pixels[tilePixel++] = colours[colour];
                          }
                      }
                  }
        }
    }
}
