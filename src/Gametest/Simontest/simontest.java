package Gametest.Simontest;

import Game.*;
import javafx.scene.canvas.GraphicsContext;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton takedamagebutton;
    int[] enemies = new int[4];
    int level = 5;

    public int cloudx = 100;
    public int cloudy = 200;
    public int startpostitionwarrior = cloudx;
    int phase = 0;
    int timepast = 0;

    Warrior warrpizza =new Warrior();
    Mage magepizza = new Mage();
    Healer healerpizza = new Healer();
    Ranger rangerpizza = new Ranger();
    private Image piz = new ImageIcon("warrior.gif").getImage();
    JLabel pizza = new JLabel(new ImageIcon("warrior.gif"));
    int[] partypizza = new int[4];

    public simontest() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon picShop = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\Simontest\\shopk.jpg");
        setContentPane(new JLabel(picShop)); //assign background
        //Icon mage = new ImageIcon("mage.gif");
        //add(new JLabel(mage));

        /*
        ImageIcon warrior = new ImageIcon("warrior.gif");
        ImageIcon ranger = new ImageIcon("ranger.gif");
        ImageIcon mage = new ImageIcon("mage.gif");
        ImageIcon healer = new ImageIcon("healer.gif");
        add(new JLabel(warrior));
        add(new JLabel(ranger));
        add(new JLabel(mage));
        add(new JLabel(healer));
         */
        add(pizza);
        pizza.setLocation(cloudx,100);

        testButton = new JButton("firestorm");
        testButton.setSize(300, 100);
        testButton.setLocation(200, 330);
        testButton.setBackground(Color.white);

        testButton2 = new JButton("move");
        testButton2.setSize(300, 100);
        testButton2.setLocation(100, 330);
        testButton2.setBackground(Color.white);

        add(testButton);
        add(testButton2);
        testButton.addActionListener(e -> spelltest("firestorm", level));
        testButton2.addActionListener(e -> {timer.start(); });

        takedamagebutton = new JButton("takedamage");
        takedamagebutton.setSize(300, 100);
        takedamagebutton.setLocation(100, 330);
        takedamagebutton.setBackground(Color.white);
        add(takedamagebutton);
        takedamagebutton.addActionListener(e -> {takedamage.start(); });


        //testButton.addActionListener(e -> musicpick.musicStart("theme"));

        //musicpick.musicStart("theme");

        //////////////////////////////////////////////////////////////////

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(10);
        takedamage.setRepeats(true);
        takedamage.setCoalesce(true);
        takedamage.setInitialDelay(10);


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
        //ta bort level å hämta direkt
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
        else if (spell.equals("arrow shootshoot blast boomboom")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        }
        else if (spell.equals("poison arrow")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        }
        else if (spell.equals("stealth")) {
            enemies[0] -= (20 * level);
            System.out.println("hides, their next normal attack will be a backstab");
            //normal attack blir backstab
        }
        else if (spell.equals("disengaged shot")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        }
        //healer
        else if (spell.equals("heal")) {
            //glöm inte Warrior warrpizza =new Warrior();
            warrpizza.hp += (40 * level);
            if (warrpizza.hp > 150){warrpizza.hp = 150;}
            System.out.println("the warrior nr " + 0 + " has " + warrpizza.hp);
        }
        else if (spell.equals("overheal")) {
            warrpizza.hp += (30 * level);
            if (warrpizza.hp > 180){warrpizza.hp = 180;}
            System.out.println("the warrior nr " + 0 + " has " + warrpizza.hp);
        }
        else if (spell.equals("group heal")) {
            //glöm inte party
            warrpizza.hp += (30 * level);
            for (int i = 0; i < 4; i++) {
                partypizza[i] -= (5 * level);
                System.out.println("enemy nr " + i + " has " + partypizza[i]);
            }
            if (warrpizza.hp > 180){warrpizza.hp = 180;}
            System.out.println("the warrior nr " + 0 + " has " + warrpizza.hp);
        }
    }


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


    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            /*rush past
                cloudx += 30;
                pizza.setLocation(cloudx, 100);

            if (cloudx > 1000) {
                pizza.setVisible(false);
            }
            if (cloudx > 2000) {
                cloudx = 100;
                pizza.setLocation(cloudx,100);
                pizza.setVisible(true);
                timer.stop();
            }
             */
            if (phase == 0){
                cloudx += 30;
                pizza.setLocation(cloudx, 100);
                if (cloudx > 200) {
                phase = 1;
                }}
            else if (phase == 1){
                cloudx -= 30;
                pizza.setLocation(cloudx, 100);
                if (cloudx < 100) {
                    phase = 0;
                    timer.stop();
                }}
            }
        });

    Timer takedamage = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (phase == 0){
                cloudx -= 30;
                pizza.setLocation(cloudx, 100);
                if (cloudx < startpostitionwarrior - 100) {
                    phase = 1;
                }}
            else if (phase == 1){
                cloudx += 30;
                pizza.setLocation(cloudx, 100);
                if (cloudx > startpostitionwarrior) {
                    phase = 2;
                }}
            else if (phase == 2){
                pizza.setVisible(false);
                timepast++;
                if(timepast > 100){
                    musicpick.musicStart("ding", "");
                    timepast = 0;
                    phase = 3;
                }
            }
            else if (phase == 3){
                pizza.setVisible(true);
                timepast++;
                if(timepast > 100){
                    timepast = 0;
                    phase = 4;
                }
            }
            else if (phase == 4){
                pizza.setVisible(false);
                timepast++;
                if(timepast > 100){
                    musicpick.musicStart("ding", "");
                    timepast = 0;
                    phase = 5;
                }
            }
            else if (phase == 5){
                pizza.setVisible(true);
                takedamage.stop();
                timepast++;
                phase = 0;

            }
    }
});
}
