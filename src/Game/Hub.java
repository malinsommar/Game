package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Hub extends JFrame {

    private JLabel gameName;
    private JButton tutorialButton, newRunButton, exitButton;
    JFrame frame = new JFrame();

    public Hub() {

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( null/*new BoxLayout( getContentPane(), BoxLayout.Y_AXIS )*/);
        setSize(1900, 1080);
        setTitle("Thwart Knight");

        ImageIcon background = new ImageIcon("leaves.jpg"); //download image
        setContentPane(new JLabel(background));

        gameName = new JLabel("--Thwart Knights--");
        gameName.setFont(new Font("Courier", Font.BOLD,100));
        gameName.setForeground(Color.white);

        newRunButton = new JButton("New Game");
        newRunButton.setSize(300,100);
        newRunButton.setLocation(500,210);
        newRunButton.setFont(new Font("Courier", Font.BOLD,27));

        tutorialButton = new JButton("Tutorial");
        tutorialButton.setSize(300,100);
        tutorialButton.setLocation(500,330);
        tutorialButton.setFont(new Font("Courier", Font.BOLD,27));

        exitButton = new JButton("Exit game");
        exitButton.setSize(300,100);
        exitButton.setLocation(500,450);
        exitButton.setFont(new Font("Courier", Font.BOLD,27));


        add(gameName);
        Dimension size = gameName.getPreferredSize();
        gameName.setBounds(240, 10, size.width, size.height);

        add(newRunButton);
        add(tutorialButton);
        add(exitButton);

        //add(panel);


        newRunButton.addActionListener(e -> frame.dispose());
        newRunButton.addActionListener(e -> new NewGame());
      //  tutorialButton.addActionListener(e -> theTutorial.Guide());
        exitButton.addActionListener(e -> System.exit(0));

        setResizable(false);
        setVisible(true);
    }
}