package Gametest.Davidtest.hubworld.Levels.tiles;

public class PathTile extends BasicTile{

    public PathTile(int id, int x, int y, int tileColour, int levelColour) {
        super(id, x, y, tileColour, levelColour);
        this.path = true;
    }
}
