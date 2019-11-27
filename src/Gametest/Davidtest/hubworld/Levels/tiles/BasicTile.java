        package Gametest.Davidtest.hubworld.Levels.tiles;

        import Gametest.Davidtest.hubworld.Levels.Level1;
        import Gametest.Davidtest.hubworld.gfx.Screen;

public class BasicTile extends Tile{
    protected int tileId;
    protected int tileColour;

    public BasicTile(int id, int x, int y, int tileColour) {
        super(id, false,false);
        this.tileId = x + y;
        this.tileColour = tileColour;
    }

    @Override
    public void render(Screen screen, Level1 level, int x, int y) {
        screen.render(x,y,tileId,tileColour, 0X00, 1);
    }
}