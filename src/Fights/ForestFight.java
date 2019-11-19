package Fights;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ForestFight extends JFrame {


    int[] enemies = new int[4];

    Font pixelMplus;
    JButton attackButton;
    JButton blockButton;
    JButton itemButton;
    JButton skillButton;
    JLabel whosTurn;
    JLabel wolf1;
    JLabel wolf2;
    JLabel wolf3;
    JLabel wolf4;
    JLabel warrior;
    JLabel mage;
    JLabel healer;
    JLabel ranger;

    JLabel playersHp;

    public int warriorCurrentHp, mageCurrentHp, healerCurrentHp, rangerCurrentHp;
    public int warriorDamage, mageDamage, healerDamage, rangerDamage;

    public ForestFight(){

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        setTitle("Forest Fight");
        importFont();

        //Background picture
        ImageIcon background = new ImageIcon("forest.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund

        importWolfGif();
        importPartyGif();
        importButtons();
        getWolfHp();

        add(attackButton);
        add(blockButton);
        add(itemButton);
        add(skillButton);

        add(wolf3);
        add(wolf4);
        add(wolf1);
        add(wolf2);

        add(ranger);
        add(warrior);
        add(mage);
        add(healer);

        hoverEffect();
        musicpick.musicStart("forest1");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        //***FIGHT***

        whosTurn = new JLabel("Warrior's turn");
        whosTurn.setFont(pixelMplus);
        whosTurn.setForeground(Color.black);
        Dimension whoSize = whosTurn.getPreferredSize();
        whosTurn.setBounds(30, 560, whoSize.width, whoSize.height);
        add(whosTurn);

        playersHp = new JLabel("Hp: "+warriorCurrentHp);
        playersHp.setFont(pixelMplus);
        playersHp.setForeground(Color.black);
        Dimension playersHpSize = whosTurn.getPreferredSize();
        playersHp.setBounds(30, 600, playersHpSize.width, playersHpSize.height);
        add(playersHp);

        JLabel wolf1Hp = new JLabel("Wolf 1 Hp: "+ enemies[0]);
        wolf1Hp.setFont(pixelMplus);
        wolf1Hp.setForeground(Color.black);
        Dimension wolf1HpSize = whosTurn.getPreferredSize();
        wolf1Hp.setBounds(620, 560, wolf1HpSize.width, wolf1HpSize.height);
        add(wolf1Hp);

        JLabel wolf2Hp = new JLabel("Wolf 2 Hp: "+ enemies[0]);
        wolf2Hp.setFont(pixelMplus);
        wolf2Hp.setForeground(Color.black);
        Dimension wolf2HpSize = whosTurn.getPreferredSize();
        wolf2Hp.setBounds(620, 595, wolf2HpSize.width, wolf2HpSize.height);
        add(wolf2Hp);

        JLabel wolf3Hp = new JLabel("Wolf 3 Hp: "+ enemies[0]);
        wolf3Hp.setFont(pixelMplus);
        wolf3Hp.setForeground(Color.black);
        Dimension wolf3HpSize = whosTurn.getPreferredSize();
        wolf3Hp.setBounds(620, 630, wolf3HpSize.width, wolf3HpSize.height);
        add(wolf3Hp);

        JLabel wolf4Hp = new JLabel("Wolf 4 Hp: "+ enemies[0]);
        wolf4Hp.setFont(pixelMplus);
        wolf4Hp.setForeground(Color.black);
        Dimension wolf4HpSize = whosTurn.getPreferredSize();
        wolf4Hp.setBounds(620, 665, wolf4HpSize.width, wolf4HpSize.height);
        add(wolf4Hp);

        /*Turn turn = new Turn();
        attackButton.addActionListener(e -> turn.changeTurn());*/

        setVisible(true);
    }

    public void getWolfHp() {

        enemies[0] = 20;
        enemies[1] = 20;
        enemies[2] = 20;
        enemies[3] = 20;
    }

    public void importButtons(){
        //Attack button
        attackButton = new JButton("Attack");
        attackButton.setSize(200, 70);
        attackButton.setLocation(840, 555);
        attackButton.setFont(pixelMplus);
        attackButton.setBackground(Color.white);
        attackButton.setBorder(null); //Remove border around button
        attackButton.setFocusPainted(false);//Remove border around text in button

        //Block button
        blockButton = new JButton("Block");
        blockButton.setSize(200, 70);
        blockButton.setLocation(1050, 555);
        blockButton.setFont(pixelMplus);
        blockButton.setBackground(Color.white);
        blockButton.setBorder(null); //Remove border around button
        blockButton.setFocusPainted(false);//Remove border around text in button

        //Item Button
        itemButton = new JButton("Item");
        itemButton.setSize(200, 70);
        itemButton.setLocation(1050, 630);
        itemButton.setFont(pixelMplus);
        itemButton.setBackground(Color.white);
        itemButton.setBorder(null); //Remove border around button
        itemButton.setFocusPainted(false);//Remove border around text in button

        //Skill Button
        skillButton = new JButton("Skill");
        skillButton.setSize(200, 70);
        skillButton.setLocation(840, 630);
        skillButton.setFont(pixelMplus);
        skillButton.setBackground(Color.white);
        skillButton.setBorder(null); //Remove border around button
        skillButton.setFocusPainted(false);//Remove border around text in button
    }


    public void importPartyGif(){
        warrior = new JLabel();
        warrior.setIcon(new ImageIcon("warrior.gif"));
        Dimension warriorSize = warrior.getPreferredSize();
        warrior.setBounds(170, 210, warriorSize.width, warriorSize.height);

        healer = new JLabel();
        healer.setIcon(new ImageIcon("healer.gif"));
        Dimension healerSize = healer.getPreferredSize();
        healer.setBounds(-30, 210, healerSize.width, healerSize.height);

        ranger = new JLabel();
        ranger.setIcon(new ImageIcon("ranger.gif"));
        Dimension rangerSize = ranger.getPreferredSize();
        ranger.setBounds(70, 290, rangerSize.width, rangerSize.height);

        mage = new JLabel();
        mage.setIcon(new ImageIcon("mage.gif"));
        Dimension mageSize = mage.getPreferredSize();
        mage.setBounds(-110, 290, mageSize.width, mageSize.height);
    }

    public void importWolfGif(){
        wolf1 = new JLabel();
        wolf1.setIcon(new ImageIcon("forestMob.gif"));
        Dimension wolfSize = wolf1.getPreferredSize();
        wolf1.setBounds(850, 320, wolfSize.width, wolfSize.height);

        wolf2 = new JLabel();
        wolf2.setIcon(new ImageIcon("forestMob.gif"));
        wolf2.setBounds(1030, 320, wolfSize.width, wolfSize.height);

        wolf3 = new JLabel();
        wolf3.setIcon(new ImageIcon("forestMob.gif"));
        wolf3.setBounds(900, 400, wolfSize.width, wolfSize.height);

        wolf4 = new JLabel();
        wolf4.setIcon(new ImageIcon("forestMob.gif"));
        wolf4.setBounds(1080, 400, wolfSize.width, wolfSize.height);

    }
    //Imports Pixel Font
    public void importFont() {

        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }
    }

    public void hoverEffect() {

        //Attack Hover
        attackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            //Change button color while hovering
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                attackButton.setBackground(Color.lightGray);
            }

            //Change back when not hovering
            public void mouseExited(java.awt.event.MouseEvent evt) {
                attackButton.setBackground(Color.white);
            }
        });

        //Block Hover
        blockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                blockButton.setBackground(Color.lightGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                blockButton.setBackground(Color.white);
            }
        });

        //Item Hover
        itemButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemButton.setBackground(Color.lightGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                itemButton.setBackground(Color.white);
            }
        });

        //Skill ActionListeners
        skillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                skillButton.setBackground(Color.lightGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                skillButton.setBackground(Color.white);
            }
        });
    }
}