package Fights;

import Armor.PlateArmor;
import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ForrestFight extends JFrame {

    Warrior warrior = new Warrior();
    Mage mage = new Mage();
    Healer healer = new Healer();
    Ranger ranger = new Ranger();
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
    JLabel playersHp;


    public int warriorCurrentHp, mageCurrentHp, healerCurrentHp, rangerCurrentHp;
    public int warriorDamage, mageDamage, healerDamage, rangerDamage;

    public ForrestFight() {

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        setTitle("Forest Fight");
        importFont();

        //Background picture
        ImageIcon background = new ImageIcon("forest.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund

        //Wolf Mob gif
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

        //Party members gif
        JLabel warrior = new JLabel();
        warrior.setIcon(new ImageIcon("warrior.gif"));
        Dimension warriorSize = warrior.getPreferredSize();
        warrior.setBounds(170, 210, warriorSize.width, warriorSize.height);

        JLabel healer = new JLabel();
        healer.setIcon(new ImageIcon("healer.gif"));
        Dimension healerSize = healer.getPreferredSize();
        healer.setBounds(-30, 210, healerSize.width, healerSize.height);

        JLabel ranger = new JLabel();
        ranger.setIcon(new ImageIcon("ranger.gif"));
        Dimension rangerSize = ranger.getPreferredSize();
        ranger.setBounds(70, 290, rangerSize.width, rangerSize.height);

        JLabel mage = new JLabel();
        mage.setIcon(new ImageIcon("mage.gif"));
        Dimension mageSize = mage.getPreferredSize();
        mage.setBounds(-110, 290, mageSize.width, mageSize.height);


        //**Create buttons**
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

        //Add Items
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

        // *** Fight ***
        getStats();

        JLabel wolf1Hp = new JLabel("Hp: "+ enemies[0]);
        wolf1Hp.setFont(pixelMplus);
        wolf1Hp.setForeground(Color.black);
        Dimension wolf1HpSize = whosTurn.getPreferredSize();
        wolf1Hp.setBounds(70, 560, wolf1HpSize.width, wolf1HpSize.height);
        add(wolf1Hp);

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


        attackButton.addActionListener(e -> changeTurn());

        setVisible(true);
    }

    public void changeTurn(){

        if (whosTurn.getText().equals("Warrior's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -warriorDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Ranger's turn");
            playersHp.setText("Hp: "+rangerCurrentHp);
        }
        else if (whosTurn.getText().equals("Ranger's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -rangerDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Mage's turn");
            playersHp.setText("Hp: "+mageCurrentHp);
        }
        else if (whosTurn.getText().equals("Mage's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -mageDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Healers's turn");
            playersHp.setText("Hp: "+healerCurrentHp);
        }
        else if (whosTurn.getText().equals("Healers's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -healerDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Enemies turn");
        }
        else if (whosTurn.getText().equals("Enemies turn")){
            attackButton.addActionListener(e -> warriorCurrentHp =-10);
            whosTurn.setText("Warrior'" + "s turn");
            playersHp.setText("Hp: "+warriorCurrentHp);

        }
    }

    public void mobDeath(){

        if(enemies[0]<1){
            wolf1.setVisible(false);
        }
        if(enemies[1]<1){
            wolf2.setVisible(false);
        }
        if(enemies[2]<1){
            wolf3.setVisible(false);
        }
        if(enemies[3]<1){
            wolf4.setVisible(false);
        }
    }

    public void getStats() {
/*
        warriorCurrentHp = warrior.setHp();
        mageCurrentHp = mage.setHp();
        healerCurrentHp = healer.setHp();
        rangerCurrentHp = ranger.setHp();

        warriorDamage = warrior.setStr();
        mageDamage = mage.setStr();
        healerDamage = mage.setStr();
        rangerDamage = ranger.setStr();
*/
        enemies[0] = 20;
        enemies[1] = 20;
        enemies[2] = 20;
        enemies[3] = 20;
    }

    public int randomTarget(){
        int target = (int) (Math.random() * 4);

        if (target == 1 && enemies[0] < 1) {
            target = 2;
        }
        if (target == 2 && enemies[1] < 1) {
            target = 3;
        }
        if (target == 3 && enemies[2] < 1) {
            target = 4;
        }
        if (target == 4 && enemies[3] <1){
            target =1;
        }
        return target;
    }

    public void wolfAttack() {
        int target = (int) (Math.random() * 4);
        int wolfDamage = (int) (Math.random() * 5) + 10;

        if (target == 0) {
            if (warriorCurrentHp < 1) {
                wolfAttack();
            }
            warriorCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked warrior, warrior lost " + wolfDamage + " hp.");
        }
        if (target == 1) {
            if (mageCurrentHp < 1) {
                wolfAttack();
            }
            mageCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked mage, warrior lost " + wolfDamage + " hp.");

        }
        if (target == 2) {
            if (rangerCurrentHp < 1) {
                wolfAttack();
            }
            rangerCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked ranger, warrior lost " + wolfDamage + " hp.");

        }
        if (target == 3) {
            if (healerCurrentHp < 1) {
                wolfAttack();
            }
            healerCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked healer, warrior lost " + wolfDamage + " hp.");

        }
    }

    public int isFightOver() {
        if (enemies[0] < 1 && enemies[1] < 1 && enemies[2] < 1 && enemies[3] < 1) {
            //Victory screen
            int awnser = 1;
            return awnser;

        }
        if (warriorCurrentHp < 1 && mageCurrentHp < 1 && healerCurrentHp < 1 && rangerCurrentHp < 1) {
            //Game over
            int awnser = 2;
            return awnser;
        }
        //fight not over
        return 3;
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

    public void hoverEffect(){

        //Attack Hover
        attackButton.addMouseListener(new java.awt.event.MouseAdapter()

        {
            //Change button color while hovering
            public void mouseEntered (java.awt.event.MouseEvent evt){
                attackButton.setBackground(Color.lightGray);
            }
            //Change back when not hovering
            public void mouseExited (java.awt.event.MouseEvent evt){
                attackButton.setBackground(Color.white);
            }
        });

        //Block Hover
        blockButton.addMouseListener(new java.awt.event.MouseAdapter()

        {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                blockButton.setBackground(Color.lightGray);
            }
            public void mouseExited (java.awt.event.MouseEvent evt){
                blockButton.setBackground(Color.white);
            }
        });

        //Item Hover
        itemButton.addMouseListener(new java.awt.event.MouseAdapter()

        {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                itemButton.setBackground(Color.lightGray);
            }
            public void mouseExited (java.awt.event.MouseEvent evt){
                itemButton.setBackground(Color.white);
            }
        });

        //Skill ActionListeners
        skillButton.addMouseListener(new java.awt.event.MouseAdapter()

        {
            public void mouseEntered (java.awt.event.MouseEvent evt){
                skillButton.setBackground(Color.lightGray);
            }
            public void mouseExited (java.awt.event.MouseEvent evt){
                skillButton.setBackground(Color.white);
            }
        });
    }
}