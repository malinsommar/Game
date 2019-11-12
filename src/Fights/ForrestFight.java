package Fights;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ForrestFight extends JFrame{

    Font pixelMplus;

    public void importFont() {

        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }
    }

    public ForrestFight(){

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        setTitle("Forrest Fight");
        importFont();

        //Background picture
        ImageIcon background = new ImageIcon("forest.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund

        ImageIcon wolf = new ImageIcon("forrestMob.gif");
        add(new JLabel(wolf));

        setVisible(true);
    }
}