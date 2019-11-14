package Gametest.Simontest;

import Game.musicpick;
import javafx.scene.canvas.GraphicsContext;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class simontest extends JFrame{

    JFrame testFrame = new JFrame();
    private JButton testButton;

    public simontest() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon picShop = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\Simontest\\shopk.jpg");
        setContentPane(new JLabel(picShop)); //assign background
        //Icon mage = new ImageIcon("mage.gif");
        //add(new JLabel(mage));

        ImageIcon warrior = new ImageIcon("warrior.gif");
        ImageIcon ranger = new ImageIcon("ranger.gif");
        ImageIcon mage = new ImageIcon("mage.gif");
        ImageIcon healer = new ImageIcon("healer.gif");
        add(new JLabel(warrior));
        add(new JLabel(ranger));
        add(new JLabel(mage));
        add(new JLabel(healer));

        testButton = new JButton("Tutorial");
        testButton.setSize(300, 100);
        testButton.setLocation(500, 330);
        testButton.setBackground(Color.white);

        add(testButton);

        testButton.addActionListener(e -> musicpick.musicStart("themefull"));

        musicpick.musicStart("themefull");


/*
        try {
            File yourFile = new File("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\Simontest\\theme.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(yourFile);
            Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioIn.getFormat()));
            clip.open(audioIn);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); //ändrar volym
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e) {
                //whatevers
        }
        */



        //BufferedImage mage2 = ImageIO.read(new File("mage.gif"));//funkar inte
        //mage2.getGraphics().drawImage(mage2 ,500, 500, null);//funkar inte

        
        /*
        BufferedImage mage2 = ImageIO.read((getClass().getResource("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\cave.jpg")));
        Graphics g = mage2.getGraphics();
        g.drawImage(mage2, 0, 0, null);
        */

        /* lägger in en bild utan collision som kan flyttas
        JLabel warrior = new JLabel();
        warrior.setIcon(new ImageIcon("warrior.gif"));
        add(warrior);
        Dimension warriorsize = warrior.getPreferredSize();
        warrior.setBounds(100, 100, warriorsize.width, warriorsize.height);
         */


        setLayout(new FlowLayout()); //Default layout
        setSize(1920, 1080);

        setVisible(true);

    }

    public static void main (String[]args) throws IOException {

        new simontest();

    }
}
