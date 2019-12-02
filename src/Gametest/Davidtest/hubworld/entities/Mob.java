package Gametest.Davidtest.hubworld.entities;

import Gametest.Davidtest.hubworld.Levels.Level1;
import Gametest.Davidtest.hubworld.Levels.tiles.Tile;

public abstract class Mob extends Entity{

    protected String name;
    protected int speed;
    protected int numSteps = 0;
    protected boolean isMoving;
    protected int movingDir = 1; //assign the direction the mob is facing
    protected int scale = 1;

    public Mob(Level1 level1, String name, int x, int y, int speed) {
        super(level1);
        this.name = name;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }
    //method to indicate where the mob is moving.
    public void move(int xa, int ya) {
        //Makes it so you can´t move two directions at once
        if (xa != 0 && ya != 0) {
            move(0, 0);
            numSteps--; //when moving it will automatically count as two moves, and therefor we add a subtraction.
            return;
        }
        numSteps++;
        //Collision detection
        if (!hasCollided(xa, ya)) {
            //add directional indicators
            if (ya < 0) movingDir = 0;
            if (ya > 0)
                movingDir = 1;
            if ( xa < 0)
                movingDir = 2;
            if (xa > 0)
                movingDir = 3;
            x += xa * speed;
            y += ya * speed;
        }
    }
    public abstract boolean hasCollided (int xa, int ya);

    //compare tiles whether they are Basic or BasicSolid-tile (seen in Tile-class).
    protected boolean isSolidTile(int xa, int ya,  int x, int y) {
        if (level1 == null) {
            return false;
        }
        //the tile you stand on before you start moving
        Tile lastTile = level1.getTile((this.x + x)>>3, (this.y + y) >> 3);
        //the tile you stand on once you've started moving
        Tile newTile = level1.getTile((this.x + x + xa)>> 3, (this.y + y + ya) >> 3);
        //checks so that that the LastTile (first tile you spawn on) isn´t a solid block. Just so you don´t get stuck
        if(!lastTile.equals(newTile) && newTile.isSolid()) {
            return true;
        }
        //if no difference is identified return false
        return false;
    }
    public String getName() {
        return name;
    }
}
