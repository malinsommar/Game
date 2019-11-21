package Fights;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ForestFight extends JFrame {

    private int turns = 1;

    private Font pixelMplus;

    private JButton attackButton;
    private JButton blockButton;
    private JButton itemButton;
    private JButton skillButton;

    private JLabel whosTurn;
    private JLabel wolf1;
    private JLabel wolf2;
    private JLabel wolf3;
    private JLabel wolf4;
    private JLabel wolf1Hp;
    private JLabel wolf2Hp;
    private JLabel wolf3Hp;
    private JLabel wolf4Hp;
    private JLabel warrior;
    private JLabel mage;
    private JLabel healer;
    private JLabel ranger;

    private JLabel playersHp;
    private JLabel attackLine;

    private int wolf1Int, wolf2Int, wolf3Int, wolf4Int;

    public int warriorCurrentHp = 30, mageCurrentHp = 30, healerCurrentHp= 30, rangerCurrentHp=30;
    public int warriorDamage=10, mageDamage=8, healerDamage=5, rangerDamage=6;

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

        wolf1Int = 20;
        wolf2Int = 20;
        wolf3Int = 20;
        wolf4Int = 20;

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
        Dimension playersHpSize = playersHp.getPreferredSize();
        playersHp.setBounds(30, 600, playersHpSize.width, playersHpSize.height);
        add(playersHp);

        wolf1Hp = new JLabel("Wolf 1: "+ wolf1Int);
        wolf1Hp.setFont(pixelMplus);
        wolf1Hp.setForeground(Color.black);
        Dimension wolf1HpSize = wolf1Hp.getPreferredSize();
        wolf1Hp.setBounds(620, 560, wolf1HpSize.width, wolf1HpSize.height);
        add(wolf1Hp);

        wolf2Hp = new JLabel("Wolf 2: "+ wolf2Int);
        wolf2Hp.setFont(pixelMplus);
        wolf2Hp.setForeground(Color.black);
        Dimension wolf2HpSize = wolf2Hp.getPreferredSize();
        wolf2Hp.setBounds(620, 595, wolf2HpSize.width, wolf2HpSize.height);
        add(wolf2Hp);

        wolf3Hp = new JLabel("Wolf 3: "+ wolf3Int);
        wolf3Hp.setFont(pixelMplus);
        wolf3Hp.setForeground(Color.black);
        Dimension wolf3HpSize = wolf3Hp.getPreferredSize();
        wolf3Hp.setBounds(620, 630, wolf3HpSize.width, wolf3HpSize.height);
        add(wolf3Hp);

        wolf4Hp = new JLabel("Wolf 4: "+ wolf4Int);
        wolf4Hp.setFont(pixelMplus);
        wolf4Hp.setForeground(Color.black);
        Dimension wolf4HpSize = wolf4Hp.getPreferredSize();
        wolf4Hp.setBounds(620, 665, wolf4HpSize.width, wolf4HpSize.height);
        add(wolf4Hp);

        attackLine = new JLabel("Your turn");
        //attackLine.setFont(pixelMplus);
        attackLine.setForeground(Color.white);
        Dimension attackLineSize = attackLine.getPreferredSize();
        attackLine.setBounds(30, 60, attackLineSize.width, attackLineSize.height);
        add(attackLine);

        itemButton.addActionListener(e -> System.exit(0)); //ska bort
        attackButton.addActionListener(e -> changeTurn());

        setVisible(true);
    }

    public void changeTurn(){

        if (turns==1 && warriorCurrentHp>=1){
            warriorAttackWolf();
            mobDeath();
            isFightOver();
            whosTurn.setText("Ranger's turn");
            playersHp.setText("Hp: "+rangerCurrentHp);
        }
        if (turns==1 && warriorCurrentHp<1){
            turns++;
        }

        if (turns ==2 && rangerCurrentHp>=1){
            rangerAttackWolf();
            mobDeath();
            isFightOver();
            whosTurn.setText("Mage's turn");
            playersHp.setText("Hp: "+mageCurrentHp);
        }
        if (turns==2 && rangerCurrentHp<1){
            turns++;
        }

        if (turns==3 && mageCurrentHp>=1){
            mageAttackWolf();
            mobDeath();
            isFightOver();
            whosTurn.setText("Healers's turn");
            playersHp.setText("Hp: "+healerCurrentHp);
        }
        if (turns==3 && mageCurrentHp<1){
            turns++;
        }

        if (turns ==4 && healerCurrentHp>=1){
            healerAttackWolf();
            mobDeath();
            isFightOver();
            playersHp.setText(" ");
            whosTurn.setText("Wolf 1 turn");
        }
        if (turns==4 && healerCurrentHp<1){
            turns++;
        }

        //    *****ENEMIES TURN******

        //Wolf 1
        if(turns==5 && wolf1Int>=1){
            wolfAttack();
            whosTurn.setText("Wolf 2 turn");
        }
        if (turns==5 && wolf1Int<1){
            turns++;
        }

        //Wolf 2
        if(turns==6 && wolf2Int>=1){
            wolfAttack();
            whosTurn.setText("Wolf 3 turn");
        }
        if (turns==6 && wolf2Int<1){
            turns++;
        }

        //Wolf3
        if(turns==7 && wolf3Int>=1){
            wolfAttack();
            whosTurn.setText("Wolf 4 turn");
        }
        if (turns==7 && wolf3Int<1){
            turns++;
        }

        //Wolf 4
        if(turns==8 && wolf4Int>=1){
            wolfAttack();
            whosTurn.setText("Warrior'" + "s turn");
            playersHp.setText("Hp: "+warriorCurrentHp);
            attackLine.setText("Your turn");
            turns=0;
        }
        if (turns==8 && wolf4Int<1){
            turns=0;
        }
        turns++;
    }

    public void warriorAttackWolf(){
        int target = randomTarget();

        if (target == 1){
            wolf1Int = wolf1Int-warriorDamage;
            wolf1Hp.setText("Wolf 1: "+ wolf1Int);
        }
        if (target == 2){
            wolf2Int=wolf2Int-warriorDamage;
            wolf2Hp.setText("Wolf 2: "+ wolf2Int);
        }
        if (target == 3){
            wolf3Int=wolf3Int-warriorDamage;
            wolf3Hp.setText("Wolf 3: "+ wolf3Int);
        }
        if (target == 4){
            wolf4Int=wolf4Int-warriorDamage;
            wolf4Hp.setText("Wolf 4: "+ wolf4Int);
        }
    }

    public void mageAttackWolf(){
        int target = randomTarget();
        if (target == 1){
            wolf1Int-=mageDamage;
            wolf1Hp.setText("Wolf 1: "+ wolf1Int);
        }
        if (target == 2){
            wolf2Int-=mageDamage;
            wolf2Hp.setText("Wolf 2: "+ wolf2Int);
        }
        if (target == 3){
            wolf3Int-=mageDamage;
            wolf3Hp.setText("Wolf 3: "+ wolf3Int);
        }
        if (target == 4){
            wolf4Int-=mageDamage;
            wolf4Hp.setText("Wolf 4: "+ wolf4Int);
        }
    }

    public void rangerAttackWolf(){
        int target = randomTarget();

        if (target == 1){
            wolf1Int-=rangerDamage;
            wolf1Hp.setText("Wolf 1: "+ wolf1Int);
        }
        if (target == 2){
            wolf2Int-=rangerDamage;
            wolf2Hp.setText("Wolf 2: "+ wolf2Int);
        }
        if (target == 3){
            wolf3Int-=rangerDamage;
            wolf3Hp.setText("Wolf 3: "+ wolf3Int);
        }
        if (target == 4){
            wolf4Int-=rangerDamage;
            wolf4Hp.setText("Wolf 4: "+ wolf4Int);
        }
    }

    public void healerAttackWolf(){

        int target = randomTarget();

        if (target == 1){
            wolf1Int-=healerDamage;
            wolf1Hp.setText("Wolf 1: "+ wolf1Int);
        }
        if (target == 2){
            wolf2Int-=healerDamage;
            wolf2Hp.setText("Wolf 2: "+ wolf2Int);
        }
        if (target == 3){
            wolf3Int-=healerDamage;
            wolf3Hp.setText("Wolf 3: "+ wolf3Int);
        }
        if (target == 4){
            wolf4Int-=healerDamage;
            wolf4Hp.setText("Wolf 4: "+ wolf4Int);
        }
    }

    public void getStats() {

        Warrior warrior = new Warrior();
        Mage mage = new Mage();
        Healer healer = new Healer();
        Ranger ranger = new Ranger();

        warriorCurrentHp=warrior.setHp();
        mageCurrentHp=mage.setHp();
        healerCurrentHp=healer.setHp();
        rangerCurrentHp=ranger.setHp();

        warriorDamage=warrior.setStr();
        mageDamage=mage.setStr();
        healerDamage=healer.setStr();
        rangerDamage=ranger.setStr();

    }

    public void isFightOver() {
        if (wolf1Int < 1 && wolf2Int < 1 && wolf3Int < 1 && wolf4Int < 1) {
            //Victory screen
            new NewGame();
            dispose();

        }
        if (warriorCurrentHp < 1 && mageCurrentHp < 1 && healerCurrentHp < 1 && rangerCurrentHp < 1) {
            //Game over
            new Hub();
            dispose();
        }
        //else fight not over
    }

    public void wolfAttack() {
        int target = (int) (Math.random() * 4);
        int wolfDamage = (int) (Math.random() * 5) + 10;

        while (true) {
            if (target == 0) {
                if (warriorCurrentHp < 1) {
                    target=1;
                }
                if (warriorCurrentHp >0) {
                    warriorCurrentHp = warriorCurrentHp - wolfDamage;
                    attackLine.setText("Wolf attacked warrior, warrior lost " + wolfDamage + " hp.");
                    break;
                }
            }
            if (target == 1) {
                if (mageCurrentHp < 1) {
                    target = 2;
                }
                if (mageCurrentHp >0) {
                    mageCurrentHp = mageCurrentHp - wolfDamage;
                    attackLine.setText("Wolf attacked mage, warrior lost " + wolfDamage + " hp.");
                    break;
                }
            }
            if (target == 2) {
                if (rangerCurrentHp < 1) {
                    target = 3;
                }
                if (rangerCurrentHp >0) {
                    rangerCurrentHp = rangerCurrentHp - wolfDamage;
                    attackLine.setText("Wolf attacked ranger, warrior lost " + wolfDamage + " hp.");
                    break;
                }
            }
            if (target == 3) {
                if (healerCurrentHp < 1) {
                    target = 0;

                }
                if (healerCurrentHp >0) {
                    healerCurrentHp = healerCurrentHp - wolfDamage;
                    attackLine.setText("Wolf attacked healer, warrior lost " + wolfDamage + " hp.");
                    break;
                }
            }
        }
    }

    public void mobDeath(){

        if(wolf1Int<=0){
            wolf1Hp = new JLabel("Wolf 1: 0");
            wolf1.setVisible(false);
        }
        if(wolf2Int<=0){
            wolf2Hp = new JLabel("Wolf 2: 0");
            wolf2.setVisible(false);
        }
        if(wolf3Int<=0){
            wolf3Hp = new JLabel("Wolf 3: 0");
            wolf3.setVisible(false);
        }
        if(wolf4Int<=0){
            wolf4Hp = new JLabel("Wolf 4: 0");
            wolf4.setVisible(false);
        }
    }

    public int randomTarget(){
        int target = (int) (Math.random() * 4)+1;

        if (target == 1 && wolf1Int < 1) {
            target = 2;
        }
        if (target == 2 && wolf2Int < 1) {
            target = 3;
        }
        if (target == 3 && wolf3Int < 1) {
            target = 4;
        }
        if (target == 4 && wolf4Int < 1) {
            target =1;
        }
        return target;
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