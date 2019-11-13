package Game;

import Fights.ForrestBossFight;
import Fights.ForrestFight;

import javax.sound.sampled.*;
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
        setLayout(null);
        setSize(1920, 1080);
        setTitle("Alterborne");
        importFont();

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
        newRunButton.setSize(300, 100);
        newRunButton.setLocation(500, 210);
        newRunButton.setFont(pixelMplus);
        newRunButton.setBackground(Color.white);
        newRunButton.setBorder(null); //Remove border around button
        newRunButton.setFocusPainted(false);//Remove border around text in button

        //Tutorial Button
        tutorialButton = new JButton("Tutorial");
        tutorialButton.setSize(300, 100);
        tutorialButton.setLocation(500, 330);
        tutorialButton.setFont(pixelMplus);
        tutorialButton.setBackground(Color.white);
        tutorialButton.setBorder(null); //Remove border around button
        tutorialButton.setFocusPainted(false);//Remove border around text in button


        //Exit Button
        exitButton = new JButton("Exit game");
        exitButton.setSize(300, 100);
        exitButton.setLocation(500, 450);
        exitButton.setFont(pixelMplus);
        exitButton.setBackground(Color.white);
        exitButton.setBorder(null); //Remove border around button
        exitButton.setFocusPainted(false);//Remove border around text in button

        // Add all items
        add(gameName);
        add(newRunButton);
        add(tutorialButton);
        add(exitButton);

        //Action Listeners for New Run Button
        //newRunButton.addActionListener(e -> clip.stop());
        newRunButton.addActionListener(e -> dispose());
        newRunButton.addActionListener(e -> new NewGame());
        newRunButton.addMouseListener(new java.awt.event.MouseAdapter() {
            //Change button color while hovering
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newRunButton.setBackground(Color.lightGray);
            }
            //Change back when not hovering
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newRunButton.setBackground(UIManager.getColor("control"));
            }
        });

        //Action Listeners for Tutorial Button
        tutorialButton.addActionListener(e -> dispose());
        tutorialButton.addActionListener(e -> new ForrestBossFight());
        tutorialButton.addMouseListener(new java.awt.event.MouseAdapter() {

            //Change button color while hovering
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tutorialButton.setBackground(Color.lightGray);
            }
            //Change back when not hovering
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tutorialButton.setBackground(UIManager.getColor("control"));
            }
        });

        //Action Listeners for Exit button
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            //Change button color while hovering
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton.setBackground(Color.lightGray);
            }
            //Change back when not hovering
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setBackground(UIManager.getColor("control"));
            }
        });

        musicpick.musicStart("mainmenumusic");

        setResizable(false);
        setVisible(true);
    }

    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }

        try {
            pixelMplus2 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(120f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }
    }
}