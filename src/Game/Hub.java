package Game;

import javax.swing.*;
import java.awt.*;


public class Hub extends JFrame {

    private JLabel gameName;
    private JButton tutorialButton, newRunButton, exitButton;
    JFrame frame = new JFrame();

    public Hub() {

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( null);
        setSize(1900, 1080);
        setTitle("Thwart Knight");

        //Background picture
        ImageIcon background = new ImageIcon("leaves.jpg"); //download image
        setContentPane(new JLabel(background));

        //Title of game
        gameName = new JLabel("Thwart Knights");
        gameName.setFont(new Font("Courier", Font.BOLD,100));
        gameName.setForeground(Color.white);
        Dimension size = gameName.getPreferredSize();
        gameName.setBounds(300, 10, size.width, size.height);

        //New run Button
        newRunButton = new JButton("New Game");
        newRunButton.setSize(300,100);
        newRunButton.setLocation(500,210);
        newRunButton.setFont(new Font("Courier", Font.BOLD,27));
        newRunButton.setBackground(Color.white);

        //Tutorial Button
        tutorialButton = new JButton("Tutorial");
        tutorialButton.setSize(300,100);
        tutorialButton.setLocation(500,330);
        tutorialButton.setFont(new Font("Courier", Font.BOLD,27));
        tutorialButton.setBackground(Color.white);


        //Exit Button
        exitButton = new JButton("Exit game");
        exitButton.setSize(300,100);
        exitButton.setLocation(500,450);
        exitButton.setFont(new Font("Courier", Font.BOLD,27));
        exitButton.setBackground(Color.white);


        //Action Listeners
        add(gameName);
        add(newRunButton);
        add(tutorialButton);
        add(exitButton);

        // Add all items
        newRunButton.addActionListener(e -> frame.dispose());
        newRunButton.addActionListener(e -> new NewGame());
        tutorialButton.addActionListener(e -> new Tutorial());
        exitButton.addActionListener(e -> System.exit(0));

        setResizable(false);
        setVisible(true);
    }
}