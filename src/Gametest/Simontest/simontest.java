package Gametest.Simontest;

import Game.Warrior;
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
import java.util.Scanner;

public class simontest extends JFrame {

    Scanner sc = new Scanner(System.in);
    JFrame testFrame = new JFrame();
    private JButton testButton;
    private JButton testButton2;
    int[] enemies = new int[4];
    int level = 5;

    public simontest() {
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

        testButton = new JButton("firestorm");
        testButton.setSize(300, 100);
        testButton.setLocation(200, 330);
        testButton.setBackground(Color.white);

        testButton2 = new JButton("fireblast");
        testButton2.setSize(300, 100);
        testButton2.setLocation(100, 330);
        testButton2.setBackground(Color.white);

        add(testButton);
        add(testButton2);
        testButton.addActionListener(e -> spelltest("firestorm", level));
        testButton2.addActionListener(e -> spelltest("fireblast", level));

        //testButton.addActionListener(e -> musicpick.musicStart("theme"));

        //musicpick.musicStart("theme");


        //////////////////////////////////////////////////////////////////

        setLayout(new FlowLayout()); //Default layout
        setSize(1900, 500);

        setVisible(true);
        sethp();
    }

    public void sethp() {
        enemies[0] = 100;
        enemies[1] = 100;
        enemies[2] = 100;
        enemies[3] = 100;
    }

    public void spelltest(String spell, int level) {
        //int health = Warrior.hp;
        //dmg = weapon damage + buffdmg + debuffdmg
        //mage
        if (spell.equals("firestorm")) {
            for (int i = 0; i < 4; i++) {
                enemies[i] -= (5 * level);
                System.out.println("enemy nr " + i + " has " + enemies[i]);
            }
        } else if (spell.equals("fireball")) {
            enemies[0] -= (10 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("pyroblast")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("arcane explosion")) {
            for (int i = 0; i < 4; i++) {
                enemies[i] -= (5 * level);
                System.out.println("enemy nr " + i + " has " + enemies[i]);
            }

        }
        //warrior
        else if (spell.equals("concussive blow")) {
            enemies[0] -= (3 * level);
            //stunned 0 true
            System.out.println("stunned the enemy, skipping it's next turn");
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        }
        else if (spell.equals("battlecry")) {
            //buffdmg = 5
            System.out.println("shouts loudly, inspireing their allies");
        }
        else if (spell.equals("demoralizing shout")) {
            //debuffdmg = 5
            System.out.println("shouts loudly, striking fear in the hearths of their enemies");
        }
        else if (spell.equals("taunt")) {
            //taunted = true
            System.out.println("insults the enemy, it is sure to attack them");
        }
        //ranger
        else if (spell.equals("arrow shotshot blast")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        }
        //healer
    }


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


    public static void main (String[]args) throws IOException {

        new simontest();

    }
}
