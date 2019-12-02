package Gametest.Davidtest.hubworld.gfx;

import java.awt.*;

//assign the four basic shade colours an int-value that can be called within the tile-class to give specified colour
public class Colours {
    public static int get(int colour1, int colour2, int colour3, int colour4) {
        return (get(colour4) << 24)  //white
                + (get(colour3) << 16) //light gray
                + (get(colour2) << 8) //dark gray
                + get(colour1); //black
    }

    private static int get(int colour) {
        if (colour < 0) return 255; //if a negative number is assigned during the process of choosing colors its assigned to won't render
        int r = colour / 100%10;
        int g = colour / 10%10;
        int b = colour % 10;
        return r * 36 + g * 6 + b;
    }
}
