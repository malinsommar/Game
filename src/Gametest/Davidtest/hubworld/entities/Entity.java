package Gametest.Davidtest.hubworld.entities;

import Gametest.Davidtest.hubworld.Levels.Level1;
import Gametest.Davidtest.hubworld.gfx.Screen;

public abstract class Entity {
    public int x,y;
    protected Level1 level1;

    public Entity(Level1 level1) {
        init(level1);
    }
    public final void init(Level1 level1) { this.level1 = level1;
    }


    public abstract void tick();

    public abstract void render(Screen screen);
}
