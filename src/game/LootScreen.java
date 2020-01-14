package game;

import javax.swing.*;
import java.awt.*;

public class LootScreen extends JFrame {

    Hub hub = new Hub();

    public LootScreen(){

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 400);
        setTitle("Forest Fight");

        JLabel gameName = new JLabel("You won");
        gameName.setForeground(Color.black);
        gameName.setFont((hub.pixelMplus.deriveFont(30f)));
        Dimension size = gameName.getPreferredSize();
        gameName.setBounds(400, 30, size.width, size.height);


        add(gameName);


        MusicPick.musicStart("mainmenu","music");
        setVisible(true);
    }
}