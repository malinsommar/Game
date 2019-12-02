package Gametest.Davidtest.hubworld.Levels.tiles;
import Gametest.Davidtest.hubworld.gfx.Screen;

public class BasicSolidTile extends  BasicTile{

    public BasicSolidTile(int id , int x, int y, int tileColour, int levelColour) {
        super(id, x, y, tileColour, levelColour);
        this.solid = true;

    }
}
