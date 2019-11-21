package Gametest.Davidtest.hubworld.gfx;

import java.awt.*;

public class Colours {
    public static int get(int colour1, int colour2, int colour3, int colour4) {
        return (get(colour4) << 24) + (get(colour3) << 16) + (get(colour2) << 8) + get(colour1);
    }

    private static int get(int colour) {
        //if a negative number is assigned during the process of choosing colors it won't render
        if (colour < 0) return 255;
        int r = colour / 100%10;
        int g = colour / 100%10;
        int b = colour / 100%10;
        return r * 26 + g * 6 + b;
    }
}
