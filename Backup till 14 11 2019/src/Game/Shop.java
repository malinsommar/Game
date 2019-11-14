package Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shop extends JFrame {

    Font pixelMplus;

    public Shop(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        setTitle("Shop");
        musicpick.musicStart("shop");
        importFont();

        ImageIcon background = new ImageIcon("tavern.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund





        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }
    }
}