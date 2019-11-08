package Game;

import javax.swing.*;
import java.awt.*;

public class NewGame {

    JFrame gameFrame = new JFrame();
    JLabel text = new JLabel("Hejhej");

    public void startGame(){

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameFrame.add(text);

        gameFrame.setLayout(new FlowLayout()); //Deafult layout
        gameFrame.setSize(1000,1000);
        gameFrame.setVisible(true);

    }
}
