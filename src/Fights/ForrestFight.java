package Fights;

import Armor.PlateArmor;
import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ForrestFight extends JFrame{

    Warrior warr = new Warrior();
    Mage mage = new Mage();
    Healer healer = new Healer();
    Ranger ranger = new Ranger();

    int[] enemies = new int[4];

    SetStats setStats = new SetStats();

    Font pixelMplus;
    JButton attackButton;
    JButton blockButton;
    JButton itemButton;
    JButton skillButton;
    int attackIndex = 0;

    int warriorCurrentHp,mageCurrentHp,healerCurrentHp,rangerCurrentHp;
    int warriorDamage,mageDamage,healerDamage,rangerDamage;

    public void getStats(){
        warr.hp=warriorCurrentHp;
        mage.hp=warriorCurrentHp;
        healer.hp=warriorCurrentHp;
        ranger.hp=warriorCurrentHp;

        warr.str=warriorDamage;
        mage.str=mageDamage;
        healer.str=healerDamage;
        ranger.str=rangerDamage;
    }

    private void fight(){

        enemies[0]=20;
        enemies[1]=20;
        enemies[2]=20;
        enemies[3]=20;

        getStats();

        while(true){

            for (int i = 1; i < 9 ; i++) {

                System.out.println("New turn");

                //Party turn
               if (i==1){
                   //Warrior
                   attackButton.addActionListener(e -> enemies[0]=-warriorDamage);

               }
               if (i==2){
                    //Ranger
                   attackButton.addActionListener(e -> enemies[0]=-rangerDamage);

               }
               if (i==3){
                    //Mage
                   attackButton.addActionListener(e -> enemies[0]=-mageDamage);

               }
               if (i==4){
                    //Healer
                   attackButton.addActionListener(e -> enemies[0]=-healerDamage);

               }
                //Enemie turn
                if (i==5){
                    //Wolf1
                    wolfAttack();
                }
                if (i==6){
                    //wolf2
                    wolfAttack();
                }
                if (i==7){
                    //wolf3
                    wolfAttack();
                }
                if (i==8){
                    //wolf4
                    wolfAttack();
                }
            }
            }
        }

        public void wolfAttack(){
            int target = (int)(Math.random()*4);
            int wolfDamage = (int)(Math.random()*5)+10;

            if (target==0){
                if(warriorCurrentHp<1){
                    wolfAttack();
                }
                warriorCurrentHp=-wolfDamage;
                System.out.println("Wolf attacked warrior, warrior lost "+wolfDamage+" hp.");
            }
            if (target==1){
                if(mageCurrentHp<1){
                    wolfAttack();
                }
                mageCurrentHp=-wolfDamage;
                System.out.println("Wolf attacked mage, warrior lost "+wolfDamage+" hp.");

            }
            if (target==2){
                if(rangerCurrentHp<1){
                    wolfAttack();
                }
                rangerCurrentHp=-wolfDamage;
                System.out.println("Wolf attacked ranger, warrior lost "+wolfDamage+" hp.");

            }
            if (target==3){
                if(healerCurrentHp<1){
                    wolfAttack();
                }
                healerCurrentHp=-wolfDamage;
                System.out.println("Wolf attacked healer, warrior lost "+wolfDamage+" hp.");

            }
        }


        public void isFightOver(){
            if (enemies[0]<1 && enemies[1]<1 && enemies[2]<1 && enemies[3]<1){
                //Victory screen
                String item = "PlateArmor";
                warr.newArmor(item);
            }
            if(warriorCurrentHp < 1 && mageCurrentHp < 1 && healerCurrentHp < 1 && rangerCurrentHp < 1){
                //Game over
                System.exit(0);
            }
        }

    public void importFont() {

        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }
    }

    public ForrestFight(){

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
        JLabel wolf1 = new JLabel();
        wolf1.setIcon(new ImageIcon("forestMob.gif"));
        Dimension wolfSize = wolf1.getPreferredSize();
        wolf1.setBounds(850, 320, wolfSize.width, wolfSize.height);

        JLabel wolf2 = new JLabel();
        wolf2.setIcon(new ImageIcon("forestMob.gif"));
        wolf2.setBounds(1030, 320, wolfSize.width, wolfSize.height);

        JLabel wolf3 = new JLabel();
        wolf3.setIcon(new ImageIcon("forestMob.gif"));
        wolf3.setBounds(900, 400, wolfSize.width, wolfSize.height);

        JLabel wolf4 = new JLabel();
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


        //Buttons
        attackButton = new JButton("Attack");
        attackButton.setSize(200, 70);
        attackButton.setLocation(840, 555);
        attackButton.setFont(pixelMplus);
        attackButton.setBackground(Color.white);
        attackButton.setBorder(null); //Remove border around button
        attackButton.setFocusPainted(false);//Remove border around text in button

        blockButton = new JButton("Block");
        blockButton.setSize(200, 70);
        blockButton.setLocation(1050, 555);
        blockButton.setFont(pixelMplus);
        blockButton.setBackground(Color.white);
        blockButton.setBorder(null); //Remove border around button
        blockButton.setFocusPainted(false);//Remove border around text in button

        itemButton = new JButton("Item");
        itemButton.setSize(200, 70);
        itemButton.setLocation(1050, 630);
        itemButton.setFont(pixelMplus);
        itemButton.setBackground(Color.white);
        itemButton.setBorder(null); //Remove border around button
        itemButton.setFocusPainted(false);//Remove border around text in button

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

        //Attack ActionListeners
        attackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            //Change button color while hovering
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                attackButton.setBackground(Color.lightGray);
            }
            //Change back when not hovering
            public void mouseExited(java.awt.event.MouseEvent evt) {
                attackButton.setBackground(Color.white);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attackIndex++;
                if (attackIndex==1) {
                    wolf1.setLocation(5000, 5000);
                }
                if (attackIndex==2) {
                    wolf2.setLocation(5000, 5000);
                }
                if (attackIndex==3) {
                    wolf3.setLocation(5000, 5000);
                }
                if (attackIndex==4) {
                    wolf4.setLocation(5000, 5000);

                }
            }
        });

        //Block ActionListeners
        blockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                blockButton.setBackground(Color.lightGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                blockButton.setBackground(Color.white);
            }
        });

        //Item ActionListeners
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

        musicpick.musicStart("forest1");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }
}