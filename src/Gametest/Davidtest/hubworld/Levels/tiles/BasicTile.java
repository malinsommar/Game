        package Gametest.Davidtest.hubworld.Levels.tiles;

        import Gametest.Davidtest.hubworld.Levels.Level1;
        import Gametest.Davidtest.hubworld.gfx.Screen;

public class BasicTile extends Tile{
    protected int tileId;
    protected int tileColour;

    public BasicTile(int id, int x, int y, int tileColour, int levelColour) {
        super(id, false,false, levelColour);
        this.tileId = x + y * 32;
        this.tileColour = tileColour;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Screen screen, Level1 level, int x, int y) {
        screen.render(x,y,tileId,tileColour, 0X00, 1);
    }
}