package Game;

import javax.swing.*;
import java.awt.*;

public class NewGame{

    JFrame gameFrame = new JFrame();
    JLabel text = new JLabel("HiHi");
    private JButton forestButton, caveButton; //

    public void startGame() {

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon picMain = new ImageIcon("tavern.jpg"); //download tavern image
        ImageIcon picForest = new ImageIcon("forest.jpg");//download cavern image
        ImageIcon picCave = new ImageIcon("cave.jpg");//download cave image
        gameFrame.setContentPane(new JLabel(picMain)); //assign background

        /*
        till senare (placerar text på botten
        studentsButton.setHorizontalTextPosition(AbstractButton.CENTER);
        studentsButton.setVerticalTextPosition(AbstractButton.BOTTOM);
         */



        gameFrame.add(text);

        gameFrame.setLayout(new FlowLayout()); //Default layout
        gameFrame.setSize(1920, 1080);
        forestButton = new JButton(picForest); //
        caveButton = new JButton(picCave); //
        gameFrame.add(forestButton); //
        gameFrame.add(caveButton); //
        gameFrame.setVisible(true);

    }
    }