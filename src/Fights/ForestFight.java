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
    private JButton endTurnButton;

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

    JLabel warriorEnergy;
    JLabel mageEnergy;
    JLabel rangerEnergy;
    JLabel healerEnergy;
    int warriorEnergyInt = 5;
    int mageEnergyInt = 5;
    int rangerEnergyInt = 5;
    int healerEnergyInt = 5;

    int attackCost = 2;
    int blockCost = 2;

    JLabel player1Hp;
    JLabel player2Hp;
    JLabel player3Hp;
    JLabel player4Hp;

    private JLabel playersHp;

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

        wolf1Int = 20;
        wolf2Int = 20;
        wolf3Int = 20;
        wolf4Int = 20;

        importWolfGif();
        importPartyGif();
        importButtons();
        hpLabels();
        energyLabels();

        add(attackButton);
        add(blockButton);
        add(itemButton);
        add(skillButton);
        add(endTurnButton);

        add(warriorEnergy);
        add(mageEnergy);
        add(rangerEnergy);
        add(healerEnergy);

        add(wolf3);
        add(wolf4);
        add(wolf1);
        add(wolf2);

        add(ranger);
        add(warrior);
        add(mage);
        add(healer);

        add(playersHp);
        add(wolf1Hp);
        add(wolf2Hp);
        add(wolf3Hp);
        add(wolf4Hp);
        add(player1Hp);
        add(player2Hp);
        add(player3Hp);
        add(player4Hp);

        hoverEffect();
        musicpick.musicStart("forest1");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        whosTurn = new JLabel("Warrior's turn");
        whosTurn.setFont(pixelMplus);
        whosTurn.setForeground(Color.black);
        Dimension whoSize = whosTurn.getPreferredSize();
        whosTurn.setBounds(30, 560, whoSize.width, whoSize.height);
        add(whosTurn);

        itemButton.addActionListener(e -> System.exit(0)); //ska bort
        attackButton.addActionListener(e -> attackPressed());
        blockButton.addActionListener(e -> blockPressed());
        endTurnButton.addActionListener(e-> startNewTurn());

        setVisible(true);
    }

    public void startNewTurn(){
        turns++;

        if (turns==1 && warriorCurrentHp>0){
            warriorEnergyInt+=5;
            whosTurn.setText("Warrior's turn");
            playersHp.setText("Hp: "+warriorCurrentHp);
        }
        if (turns==1 && warriorCurrentHp<1){
            turns=2;
        }
        if (turns==2 && rangerCurrentHp>0){
            rangerEnergyInt+=5;
            whosTurn.setText("Ranger's turn");
            playersHp.setText("Hp: "+rangerCurrentHp);
        }
        if (turns==2 && rangerCurrentHp<1){
            turns=3;
        }
        if (turns==3 && mageCurrentHp>0){
            mageEnergyInt+=5;
            whosTurn.setText("Mage's turn");
            playersHp.setText("Hp: "+mageCurrentHp);
        }
        if (turns==3 && mageCurrentHp<1){
            turns=4;
        }
        if (turns==4 && healerCurrentHp>0){
            healerEnergyInt+=5;
            whosTurn.setText("Healer's turn");
            playersHp.setText("Hp: "+healerCurrentHp);
        }
        if (turns==4 && healerCurrentHp<1){
            turns=5;
        }
        //  ***ENEMIES TURN***
        if (turns==5 && wolf1Int>0){
            whosTurn.setText("Wolf 1 turn");
            playersHp.setText("Hp: "+wolf1Int);
        }
        if (turns==1 && wolf1Int<1){
            turns=6;
        }
        if (turns==6 && wolf2Int>0){
            whosTurn.setText("Wolf 2 turn");
            playersHp.setText("Hp: "+wolf2Int);
        }
        if (turns==6 && wolf2Int<1){
            turns=7;
        }
        if (turns==7 && wolf3Int>0){
            whosTurn.setText("Wolf 3 turn");
            playersHp.setText("Hp: "+wolf3Int);

        }
        if (turns==7 && wolf4Int<1){
            turns=8;
        }
        if (turns==8 && wolf4Int>0){
            whosTurn.setText("Wolf 4 turn");
            playersHp.setText("Hp: "+wolf4Int);
            turns=0;
        }
        if (turns==8 && wolf4Int<1){
            turns=0;
            startNewTurn();
        }
    }
    private void blockPressed(){

        if(turns==1){
            warriorCurrentHp+=5;
            player1Hp.setText("Warrior: "+warriorCurrentHp);
            playersHp.setText("Hp:"+warriorCurrentHp);
        }
        else if(turns==2){
            rangerCurrentHp+=5;
            player3Hp.setText("Ranger:  "+rangerCurrentHp);
            playersHp.setText("Hp: "+rangerCurrentHp);
        }
        else if(turns==3){
            mageCurrentHp+=5;
            player2Hp.setText("Mage:    "+mageCurrentHp);
            playersHp.setText("Hp: "+mageCurrentHp);

        }
        else if(turns==4){
            healerCurrentHp+=5;
            player4Hp.setText("Healer:  "+healerCurrentHp);
            playersHp.setText("Hp: "+healerCurrentHp);
        }
    }

    public void attackPressed(){

        if(turns==1){
            warriorAttackWolf();
            mobDeath();
            isFightOver();
        }
        else if(turns==2){
            rangerAttackWolf();
            mobDeath();
            isFightOver();
        }
        else if(turns==3){
            mageAttackWolf();
            mobDeath();
            isFightOver();
        }
        else if(turns==4){
            healerAttackWolf();
            mobDeath();
            isFightOver();
        }
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
                    player1Hp.setText("Warrior: "+warriorCurrentHp);
                    break;
                }
            }
            if (target == 1) {
                if (mageCurrentHp < 1) {
                    target = 2;
                }
                if (mageCurrentHp >0) {
                    mageCurrentHp = mageCurrentHp - wolfDamage;
                    player2Hp.setText("Mage:    "+mageCurrentHp);
                    break;
                }
            }
            if (target == 2) {
                if (rangerCurrentHp < 1) {
                    target = 3;
                }
                if (rangerCurrentHp >0) {
                    rangerCurrentHp = rangerCurrentHp - wolfDamage;
                    player3Hp.setText("Ranger:  "+rangerCurrentHp);
                    break;
                }
            }
            if (target == 3) {
                if (healerCurrentHp < 1) {
                    target = 0;

                }
                if (healerCurrentHp >0) {
                    healerCurrentHp = healerCurrentHp - wolfDamage;
                    player4Hp.setText("Healer:   "+healerCurrentHp);
                    break;
                }
            }
        }
    }

    public void mobDeath(){

        if(wolf1Int<=0){
            wolf1Hp.setText("Wolf 1: 0");
            wolf1.setVisible(false);
        }
        if(wolf2Int<=0){
            wolf2Hp.setText("Wolf 2: 0");
            wolf2.setVisible(false);
        }
        if(wolf3Int<=0){
            wolf3Hp.setText("Wolf 3: 0");
            wolf3.setVisible(false);
        }
        if(wolf4Int<=0){
            wolf4Hp.setText("Wolf 4: 0");
            wolf4.setVisible(false);
        }
    }

    public void partyDeath(){

        if(warriorCurrentHp<=0){
            player1Hp.setText("Warrior: 0");
            warrior.setVisible(false);
        }
        if(mageCurrentHp<=0){
            player2Hp.setText("Mage:    0");
            mage.setVisible(false);
        }
        if(rangerCurrentHp<=0){
            player3Hp.setText("Ranger:  0");
            ranger.setVisible(false);
        }
        if(healerCurrentHp<=0){
            player4Hp.setText("Healer:  0");
            player4Hp.setVisible(false);
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

    public void hpLabels(){
        playersHp = new JLabel("Hp: "+warriorCurrentHp);
        playersHp.setFont(pixelMplus);
        playersHp.setForeground(Color.black);
        Dimension playersHpSize = playersHp.getPreferredSize();
        playersHp.setBounds(30, 600, playersHpSize.width, playersHpSize.height);

        wolf1Hp = new JLabel("Wolf 1: "+ wolf1Int);
        wolf1Hp.setFont(pixelMplus);
        wolf1Hp.setForeground(Color.black);
        Dimension wolf1HpSize = wolf1Hp.getPreferredSize();
        wolf1Hp.setBounds(620, 560, wolf1HpSize.width, wolf1HpSize.height);

        wolf2Hp = new JLabel("Wolf 2: "+ wolf2Int);
        wolf2Hp.setFont(pixelMplus);
        wolf2Hp.setForeground(Color.black);
        Dimension wolf2HpSize = wolf2Hp.getPreferredSize();
        wolf2Hp.setBounds(620, 595, wolf2HpSize.width, wolf2HpSize.height);

        wolf3Hp = new JLabel("Wolf 3: "+ wolf3Int);
        wolf3Hp.setFont(pixelMplus);
        wolf3Hp.setForeground(Color.black);
        Dimension wolf3HpSize = wolf3Hp.getPreferredSize();
        wolf3Hp.setBounds(620, 630, wolf3HpSize.width, wolf3HpSize.height);

        wolf4Hp = new JLabel("Wolf 4: "+ wolf4Int);
        wolf4Hp.setFont(pixelMplus);
        wolf4Hp.setForeground(Color.black);
        Dimension wolf4HpSize = wolf4Hp.getPreferredSize();
        wolf4Hp.setBounds(620, 665, wolf4HpSize.width, wolf4HpSize.height);

        player1Hp = new JLabel("Warrior: "+ warriorCurrentHp);
        player1Hp.setFont(pixelMplus);
        player1Hp.setForeground(Color.black);
        Dimension player1HpSize = player1Hp.getPreferredSize();
        player1Hp.setBounds(410, 560, player1HpSize.width, player1HpSize.height);

        player2Hp = new JLabel("Mage:    "+ mageCurrentHp);
        player2Hp.setFont(pixelMplus);
        player2Hp.setForeground(Color.black);
        Dimension player2HpSize = player1Hp.getPreferredSize();
        player2Hp.setBounds(410, 595, player2HpSize.width, player2HpSize.height);

        player3Hp = new JLabel("Ranger:  "+ rangerCurrentHp);
        player3Hp.setFont(pixelMplus);
        player3Hp.setForeground(Color.black);
        Dimension player3HpSize = player3Hp.getPreferredSize();
        player3Hp.setBounds(410, 630, player3HpSize.width, player3HpSize.height);

        player4Hp = new JLabel("Healer:  "+ rangerCurrentHp);
        player4Hp.setFont(pixelMplus);
        player4Hp.setForeground(Color.black);
        Dimension player4HpSize = player4Hp.getPreferredSize();
        player4Hp.setBounds(410, 665, player4HpSize.width, player4HpSize.height);
    }

    public void energyLabels(){

        warriorEnergy = new JLabel("Energy: "+warriorEnergyInt);
        warriorEnergy.setFont(pixelMplus);
        warriorEnergy.setForeground(Color.black);
        Dimension warriorEnergySize = warriorEnergy.getPreferredSize();
        warriorEnergy.setBounds(30, 640, warriorEnergySize.width, warriorEnergySize.height);

        mageEnergy = new JLabel("Energy: "+mageEnergyInt);
        mageEnergy.setFont(pixelMplus);
        mageEnergy.setForeground(Color.black);
        Dimension mageEnergySize = mageEnergy.getPreferredSize();
        mageEnergy.setBounds(410, 560, mageEnergySize.width, mageEnergySize.height);
        mageEnergy.setVisible(false);

        rangerEnergy = new JLabel("Energy: "+rangerEnergyInt);
        rangerEnergy.setFont(pixelMplus);
        rangerEnergy.setForeground(Color.black);
        Dimension rangerEnergySize = rangerEnergy.getPreferredSize();
        rangerEnergy.setBounds(410, 560, rangerEnergySize.width, rangerEnergySize.height);
        rangerEnergy.setVisible(false);

        healerEnergy = new JLabel("Energy: "+healerEnergyInt);
        healerEnergy.setFont(pixelMplus);
        healerEnergy.setForeground(Color.black);
        Dimension healerEnergySize = warriorEnergy.getPreferredSize();
        healerEnergy.setBounds(410, 560, healerEnergySize.width, healerEnergySize.height);
        healerEnergy.setVisible(false);
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

        //End Turn Button
        endTurnButton = new JButton("End turn");
        endTurnButton.setSize(200, 70);
        endTurnButton.setLocation(540, 468);
        endTurnButton.setFont(pixelMplus);
        endTurnButton.setBackground(Color.white);
        endTurnButton.setBorder(null); //Remove border around button
        endTurnButton.setFocusPainted(false);//Remove border around text in button
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

        //End turn ActionListeners
        endTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                endTurnButton.setBackground(Color.lightGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                endTurnButton.setBackground(Color.white);
            }
        });
    }
}