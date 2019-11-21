package Game;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoseScreen extends JFrame {

    JLabel backStory;

    public LoseScreen() {
        setLayout(null);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);

        ImageIcon picwin= new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\newGameBackground.jpg");
        setContentPane(new JLabel(picwin));

        backStory = new JLabel("Victory Achieved.");
        backStory.setForeground(Color.white);
        Dimension size = backStory.getPreferredSize();
        backStory.setBounds(170, 100, size.width, size.height);

        add(backStory);

        musicpick.musicStart("shop");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
