package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Hub {
    private JLabel gameName;
    private JButton tutorialButton, newRunButton, exitButton;
    Scanner sc = new Scanner(System.in);
    JFrame frame = new JFrame();
    NewGame theGame = new NewGame();
    Tutorial theTutorial = new Tutorial();
    public Hub() {
        frameMenu();
    }

    //JFrame
    public void frameMenu() {
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = (JPanel) frame.getContentPane(); //A package you can put many labels/buttons into sort them.
        panel.setLayout(null);
        frame.setTitle("*Thwart Knights*");
        gameName = new JLabel("*Thwart Knights*");
        newRunButton = new JButton("New Game");
        tutorialButton = new JButton("Tutorial");
        exitButton = new JButton("Exit game");
        panel.add(gameName);
        Dimension size = gameName.getPreferredSize();
        gameName.setBounds(240, 10, size.width, size.height);  //Indicates where the label should be. layout is with.
        panel.add(newRunButton);
        frame.add(tutorialButton);
        frame.add(exitButton);

        frame.setLayout(new FlowLayout()); //Default layout
        frame.setSize(600, 300);
        frame.setVisible(true);

        newRunButton.addActionListener(e -> frame.dispose());
        newRunButton.addActionListener(e -> theGame.startGame());
        tutorialButton.addActionListener(e -> theTutorial.Guide());
        exitButton.addActionListener(e -> System.exit(0));
    }
}

