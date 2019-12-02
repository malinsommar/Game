package Gametest.Davidtest.hubworld.entities;


import Gametest.Davidtest.hubworld.Levels.Level1;
import Gametest.Davidtest.hubworld.gfx.Colours;
import Gametest.Davidtest.hubworld.gfx.Screen;
import Gametest.Davidtest.hubworld.hub.InputHandler;

public class Player extends Mob {

    private InputHandler input;
    private int colour = Colours.get(-1,111,111,543); //Assign colour for character which will be calculated within the Colours-class
    //assign size to character
    private int scale = 1; //Player size

    public Player(Level1 level1, int x, int y, InputHandler input) {
        super(level1, "Player", x, y, 1);
        this.input = input;
    }


    @Override
    //updates isPressed method based on player-input every time the tick counts up by one
    public void tick() {
        /*up, down, left and right are identified with keyboard-inputs the xa or ya based on axel. When an assigned
        button is pressed, the xa or ya subs or adds by one, updating the movement*/

        int xa = 0;
        int ya = 0;
        if (input != null) {
            if (input.up.isPressed()) {
                ya--;
            }

            if (input.down.isPressed()) {
                ya++;
            }
            if (input.left.isPressed()) {
                xa--;
            }

            if (input.right.isPressed()) {
                xa++;
            }
            //sets the default value of isMoving to false if character isn't moving
            if (xa != 0 || ya != 0) {
                move(xa, ya);
                isMoving = true;
            } else {
                isMoving = false;
            }
        }
    }
    @Override
    //render character on screen
    public void render(Screen screen) {
        int xTile = 0;
        int yTile = 28;
        int walkingSpeed = 4;//character walk speed
        //the value of the top part of the 8x8 sprite
        int flipTop = (numSteps >> walkingSpeed) & 1;
        //the value of the bottom part of the 8x8 sprite
        int flipBottom = (numSteps >> walkingSpeed) & 1;

        //change which group pixels are being presented for the character
        if (movingDir == 1) {
            //moves to the second 8x8 sprite
            xTile += 2;
            //moves to the third(?) 8x8 sprite
        } else if (movingDir > 1) {
            xTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
            flipTop = (movingDir - 1) % 2;
        }
        int modifier = 8 * scale;
        int xOffset = x - modifier/2;
        int yOffset = y - modifier/2 - 4;


        screen.render(xOffset + (modifier * flipTop), yOffset, xTile + yTile * 32, colour, flipTop, scale);
        screen.render(xOffset + modifier - (modifier * flipTop), yOffset, (xTile + 1) + yTile * 32, colour, flipTop, scale);

        screen.render(xOffset  + (modifier * flipBottom), yOffset + modifier, xTile + (yTile + 1) * 32, colour, flipBottom, scale);
        screen.render(xOffset + modifier - (modifier * flipBottom), yOffset + modifier, (xTile + 1) + (yTile + 1) * 32, colour, flipBottom, scale);

    }

    @Override
    //create a collisionBox for where a function will activate if character interacts with a thing within that box
    public boolean hasCollided(int xa, int ya) {
        //top left corner
         int xMin = 0;
         //top right corner
        int xMax = 5;
        //bottom left corner
        int yMin = 3;
        //bottom right corner
        int yMax = 5;
        //create a loop between the top left and top right corner
        for (int x = xMin; x < xMax; x++) {
            if (isSolidTile(xa, ya, x, yMin)) {
                return true;
            }
        }
        //creates a loop between bottom left and top right corner
            for (int x = xMin; x < xMax; x++) {
                if (isSolidTile(xa,ya,x,yMax)) {
                    return true;
                }
        }
            //create a loop between top left and bottom left corner
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile(xa, ya, xMin, y)) {
                return true;
            }
        }
        //create a loop between top right and bottom right corner
        for (int y = yMin; y < yMax; y++) {
            if (isSolidTile(xa, ya, xMax, y)) {
                return true;
            }
        }
        return false;
    }
}
