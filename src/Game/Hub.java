package Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Hub extends JFrame {

    private JLabel gameName;
    private JButton tutorialButton, newRunButton, exitButton;
    Font pixelMplus;
    Font pixelMplus2;

    public Hub() {

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( null);
        setSize(1900, 1080);
        setTitle("Alterborne");


        //Import font
        try{
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        }
        catch(IOException | FontFormatException e){

        }

        try{
            pixelMplus2 =  Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(120f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        }
        catch(IOException | FontFormatException e){

        }

        //Background picture
        ImageIcon background = new ImageIcon("bakgrundMountain.png"); //download image
        setContentPane(new JLabel(background)); //set backgrund

        //Title of game
        gameName = new JLabel("Alterborne");
        gameName.setForeground(Color.white);
        gameName.setFont(pixelMplus2);

        Dimension size = gameName.getPreferredSize();
        gameName.setBounds(350, 10, size.width, size.height);

        //New run Button
        newRunButton = new JButton("New Game");
        newRunButton.setSize(300,100);
        newRunButton.setLocation(500,210);
        newRunButton.setFont(pixelMplus);
        newRunButton.setBackground(Color.white);

        //Tutorial Button
        tutorialButton = new JButton("Tutorial");
        tutorialButton.setSize(300,100);
        tutorialButton.setLocation(500,330);
        tutorialButton.setFont(pixelMplus);
        tutorialButton.setBackground(Color.white);


        //Exit Button
        exitButton = new JButton("Exit game");
        exitButton.setSize(300,100);
        exitButton.setLocation(500,450);
        exitButton.setFont(pixelMplus);
        exitButton.setBackground(Color.white);

        // Add all items
        add(gameName);
        add(newRunButton);
        add(tutorialButton);
        add(exitButton);

        //Action Listeners
        newRunButton.addActionListener(e -> dispose());
        newRunButton.addActionListener(e -> new NewGame());
        tutorialButton.addActionListener(e -> new Tutorial());
        exitButton.addActionListener(e -> System.exit(0));

        setResizable(false);
        setVisible(true);
    }
}