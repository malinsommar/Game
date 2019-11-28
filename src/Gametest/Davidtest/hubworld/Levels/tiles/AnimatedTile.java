package Gametest.Davidtest.hubworld.Levels.tiles;

import Gametest.Davidtest.hubworld.Levels.Level1;
import Gametest.Davidtest.hubworld.gfx.Screen;

import java.util.logging.Level;

public class AnimatedTile extends BasicTile {

    private int[][] animationTileCoords;
    private int currentAnimationIndex;
    private long lastIterationTime;
    private int animationSwitchDelay;

    public AnimatedTile(int id, int [][] animationCoords, int tileColour, int levelColour, int animationSwitchDelay) {
        super(id, animationCoords[0][0], animationCoords[0][1], tileColour, levelColour);
        this.animationTileCoords = animationCoords;
        this.currentAnimationIndex = 0;
        this.lastIterationTime = System.currentTimeMillis();
        this.animationSwitchDelay = animationSwitchDelay;

    }
    //moves the array from the first frame to the second and on
    public void tick() {
        if ((System.currentTimeMillis() - lastIterationTime) >= (animationSwitchDelay)) {
    lastIterationTime = System.currentTimeMillis();
    //puts a block on the loop so it does not go past the limit
    currentAnimationIndex = (currentAnimationIndex +1) % animationTileCoords.length;
    this.tileId = (animationTileCoords[currentAnimationIndex][0] + (animationTileCoords[currentAnimationIndex][1] * 32));
        }
    }

    }