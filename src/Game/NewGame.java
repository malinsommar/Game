package Game;

import javax.swing.*;
import java.awt.*;

public class NewGame{

    JFrame gameFrame = new JFrame();
    JLabel text = new JLabel("HiHi");
    private JButton forestButton, caveButton; //

    public void startGame() {

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon picmain = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Game\\tavern.jpg"); //laddar tavern bild
        ImageIcon picforest = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Game\\forest.jpg");//laddar forest bild
        ImageIcon piccave = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Game\\cave.jpg");//laddar cave bild
        //String picmenu = ("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Game\\tavern.jpg"); hehe pathen är en string hehe
        gameFrame.setContentPane(new JLabel(picmain)); //sätter backgrundsbild
        /*
        till senare (placerar text på botten
        studentsButton.setHorizontalTextPosition(AbstractButton.CENTER);
        studentsButton.setVerticalTextPosition(AbstractButton.BOTTOM);
         */



        gameFrame.add(text);

        gameFrame.setLayout(new FlowLayout()); //Default layout
        gameFrame.setSize(1920, 1080);
        gameFrame.setVisible(true);
        forestButton = new JButton(picforest); //
        caveButton = new JButton(piccave); //
        gameFrame.add(forestButton); //
        gameFrame.add(caveButton); //

    }
    }