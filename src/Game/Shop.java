package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Shop extends JFrame {

    Inventory inv = new Inventory();

    Font pixelMplus;
    JButton potion1, potion2, potion3, potion4, potion5, potion6, potion7, potion8, potion9, potion10, potion11, potion12;

    public Shop(){
        super("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        musicpick.musicStart("shop", "music");

        importFont();
        addButtons();

        add(potion1);
        add(potion2);
        add(potion3);

        /*ImageIcon background = new ImageIcon("tavern.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund*/

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    public void buyPotion(){




    }

    private void addButtons(){

        potion1 = new JButton(inv.minorHealthGif);
        potion1.setSize(300, 300);
        potion1.setLocation(100, 100);

        potion2 = new JButton(inv.lesserHealthGif);
        potion2.setSize(300, 300);
        potion2.setLocation(500, 100);

        potion3 = new JButton(inv.majorHealthGif);
        potion3.setSize(300, 300);
        potion3.setLocation(500, 100);
    }

    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
        } catch (IOException | FontFormatException e) {
        }
    }
}