package Fights;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ForestFight extends JFrame {

    private Inventory inv = new Inventory();
    private Warrior w = new Warrior();
    private Mage m = new Mage();
    private Healer h = new Healer();
    private Ranger r = new Ranger();

    private Font pixelMplus;

    private JButton attackButton, blockButton, itemButton, skillButton, endTurnButton;
    private JButton exitInventory, potion1, potion2, potion3, potion4, potion5, potion6, potion7, potion8, potion9, potion10, potion11, potion12;

    private JLabel whosTurn, energy, block;
    private JLabel wolf1, wolf2, wolf3, wolf4;
    private JLabel wolf1Hp, wolf2Hp, wolf3Hp, wolf4Hp;
    private JLabel warrior, mage, healer, ranger;
    private JLabel playersHp, player1Hp, player2Hp, player3Hp, player4Hp;


    private int turns = 1;
    private int currentEnergy;
    private int warriorEnergyInt=5, mageEnergyInt, rangerEnergyInt, healerEnergyInt;
    private int wolf1Int, wolf2Int, wolf3Int, wolf4Int;

    //Get hp, block and damage from party
    private int warriorCurrentHp = w.hp, mageCurrentHp = m.hp, healerCurrentHp = h.hp, rangerCurrentHp = r.hp;
    private int warriorDamage = w.combinedDamage, mageDamage = m.combinedDamage, healerDamage = h.combinedDamage, rangerDamage = r.combinedDamage;
    private int warriorBlock = w.combinedBlock, mageBlock = m.combinedBlock, healerBlock = h.combinedBlock, rangerBlock = r.combinedBlock;

    public ForestFight(){

        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        setTitle("Forest Fight");
        importFont();
        System.out.println(w.combinedBlock);

        //Background picture
        ImageIcon background = new ImageIcon("forest.jpg");
        setContentPane(new JLabel(background));

        wolf1Int = 20;
        wolf2Int = 20;
        wolf3Int = 20;
        wolf4Int = 20;
        currentEnergy=warriorEnergyInt;

        importWolfGif();
        importPartyGif();
        importButtons();
        importLabels();

        //Add all Labels, buttons etc.
        add(energy);
        add(block);
        add(whosTurn);
        add(attackButton);
        add(blockButton);
        add(itemButton);
        add(skillButton);
        add(endTurnButton);
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
        musicpick.musicStart("forest1","music");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        //ActionListeners
        attackButton.addActionListener(e -> attackPressed());
        blockButton.addActionListener(e -> blockPressed());
        itemButton.addActionListener(e -> itemPressed());
        skillButton.addActionListener(e -> System.exit(0)); //tillfällig
        endTurnButton.addActionListener(e-> startNewTurn());

        setVisible(true);
    }

    public void itemPressed(){

        //Frame settings
        JFrame inventory = new JFrame();
        inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventory.setLayout(null);
        inventory.setSize(1920, 300);
        inventory.setTitle("Inventory");
        inventory.setLocation(0,538);

        getInventoryStuff();

        //Background
        ImageIcon backgroundInventory = new ImageIcon("white.jpg");
        inventory.setContentPane(new JLabel(backgroundInventory));

        inventory.add(exitInventory);
        inventory.add(potion1);
        inventory.add(potion2);
        inventory.add(potion3);
        inventory.add(potion4);
        inventory.add(potion5);
        inventory.add(potion6);
        inventory.add(potion7);
        inventory.add(potion8);
        inventory.add(potion9);
        inventory.add(potion10);
        inventory.add(potion11);
        inventory.add(potion12);

        potion1.addActionListener(e->usePotion(1));
        potion2.addActionListener(e->usePotion(2));
        potion3.addActionListener(e->usePotion(3));
        potion4.addActionListener(e->usePotion(4));
        potion5.addActionListener(e->usePotion(5));
        potion6.addActionListener(e->usePotion(6));
        potion7.addActionListener(e->usePotion(7));
        potion8.addActionListener(e->usePotion(8));
        potion9.addActionListener(e->usePotion(9));
        potion10.addActionListener(e->usePotion(10));
        potion11.addActionListener(e->usePotion(11));
        potion12.addActionListener(e->usePotion(12));

        exitInventory.addActionListener(e->inventory.dispose());

        inventory.setUndecorated(true);
        inventory.setVisible(true);
    }
    public void usePotion(int potion){



    }

    public void getInventoryStuff(){
        //Exit button
        exitInventory = new JButton("Exit inventory");
        exitInventory.setBounds(1010,60,250,80);
        exitInventory.setFont(pixelMplus.deriveFont(30f));
        exitInventory.setBackground(Color.white);
        exitInventory.setBorder(null); //Remove border around button
        exitInventory.setFocusPainted(false);//Remove border around text in button

        //Minor Health Potion
        potion1 = new JButton(inv.minorHealthGif);
        potion1.setBounds(50,60,41,62);
        potion1.setBackground(Color.white);
        potion1.setBorder(null);
        potion1.setFocusPainted(false);

        //Lesser Health Potion
        potion2 = new JButton(inv.lesserHealthGif);
        potion2.setBounds(100,60,46,62);
        potion2.setBackground(Color.white);
        potion2.setBorder(null);
        potion2.setFocusPainted(false);

        //Major Health Potion
        potion3 = new JButton(inv.majorHealthGif);
        potion3.setBounds(160,60,55,64);
        potion3.setBackground(Color.white);
        potion3.setBorder(null);
        potion3.setFocusPainted(false);

        //Minor Block Potion
        potion4 = new JButton(inv.minorBlockGif);
        potion4.setBounds(300,60,42,63);
        potion4.setBackground(Color.white);
        potion4.setBorder(null);
        potion4.setFocusPainted(false);

        //Lesser Block Potion
        potion5 = new JButton(inv.lesserBlockGif);
        potion5.setBounds(350,60,47,63);
        potion5.setBackground(Color.white);
        potion5.setBorder(null);
        potion5.setFocusPainted(false);

        //Major Block Potion
        potion6 = new JButton(inv.majorBlockGif);
        potion6.setBounds(410,60,59,64);
        potion6.setBackground(Color.white);
        potion6.setBorder(null);
        potion6.setFocusPainted(false);

        //Minor Energy Potion
        potion7 = new JButton(inv.minorEnergyGif);
        potion7.setBounds(550,60,40,63);
        potion7.setBackground(Color.white);
        potion7.setBorder(null);
        potion7.setFocusPainted(false);

        //Lesser Energy Potion
        potion8 = new JButton(inv.lesserEnergyGif);
        potion8.setBounds(600,60,46,63);
        potion8.setBackground(Color.white);
        potion8.setBorder(null);
        potion8.setFocusPainted(false);

        //Major Energy Potion
        potion9 = new JButton(inv.majorEnergyGif);
        potion9.setBounds(660,60,59,64);
        potion9.setBackground(Color.white);
        potion9.setBorder(null);
        potion9.setFocusPainted(false);

        //Minor Strength Potion
        potion10 = new JButton(inv.minorStrGif);
        potion10.setBounds(800,60,38,63);
        potion10.setBackground(Color.white);
        potion10.setBorder(null);
        potion10.setFocusPainted(false);

        //Lesser Energy Potion
        potion11 = new JButton(inv.lesserStrGif);
        potion11.setBounds(850,60,42,63);
        potion11.setBackground(Color.white);
        potion11.setBorder(null);
        potion11.setFocusPainted(false);

        //Major Energy Potion
        potion12 = new JButton(inv.majorStrGif);
        potion12.setBounds(900,60,53,64);
        potion12.setBackground(Color.white);
        potion12.setBorder(null);
        potion12.setFocusPainted(false);
    }

    private void startNewTurn(){
        turns++;

        //Warrior's turn
        if (turns==1 && warriorCurrentHp>0){
            warriorEnergyInt+=5;
            currentEnergy=warriorEnergyInt;
            warriorBlock=w.combinedBlock;

            if (warriorEnergyInt>10){
                warriorEnergyInt=10;
            }
            whosTurn.setText("Warrior's turn");
            playersHp.setText("Hp: "+warriorCurrentHp);
            energy.setText("Energy: "+warriorEnergyInt);
            block.setText("Block: "+warriorBlock);
        }
        //If warrior is dead, skip.
        if (turns==1 && warriorCurrentHp<1){
            turns=2;
        }
        //Ranger's turn
        if (turns==2 && rangerCurrentHp>0){
            rangerEnergyInt+=5;
            currentEnergy=rangerEnergyInt;
            rangerBlock=r.combinedBlock;

            if (rangerEnergyInt>10){
                rangerEnergyInt=10;
            }
            whosTurn.setText("Ranger's turn");
            playersHp.setText("Hp: "+rangerCurrentHp);
            energy.setText("Energy: "+rangerEnergyInt);
            block.setText("Block: "+rangerBlock);
        }
        //If ranger is dead, skip.
        if (turns==2 && rangerCurrentHp<1){
            turns=3;
        }
        //Mage's turn
        if (turns==3 && mageCurrentHp>0){
            mageEnergyInt+=5;
            currentEnergy=mageEnergyInt;
            mageBlock=m.combinedBlock;

            if (mageEnergyInt>10){
                mageEnergyInt=10;
            }
            whosTurn.setText("Mage's turn");
            playersHp.setText("Hp: "+mageCurrentHp);
            energy.setText("Energy: "+mageEnergyInt);
            block.setText("Block: "+mageBlock);
        }
        //If mage is dead, skip.
        if (turns==3 && mageCurrentHp<1){
            turns=4;
        }
        //Healer's turn
        if (turns==4 && healerCurrentHp>0){
            healerEnergyInt+=5;
            currentEnergy=healerEnergyInt;
            healerBlock=h.combinedBlock;

            if (healerEnergyInt>10){
                healerEnergyInt=10;
            }
            whosTurn.setText("Healer's turn");
            playersHp.setText("Hp: "+healerCurrentHp);
            energy.setText("Energy: "+healerEnergyInt);
            block.setText("Block: "+healerBlock);

        }
        //If healer is dead, skip.
        if (turns==4 && healerCurrentHp<1){
            turns=5;
        }
        //  ***ENEMIES TURN***
        //Wolf 1
        if (turns==5 && wolf1Int>0){
            whosTurn.setText("Wolf 1 turn");
            playersHp.setText("Hp: "+wolf1Int);
            energy.setText("  ");
            wolfAttack();
            partyDeath();
        }
        //If wolf 1 is dead, skip.
        if (turns==5 && wolf1Int<1){
            turns=6;
        }
        //Wolf 2
        if (turns==6 && wolf2Int>0){
            whosTurn.setText("Wolf 2 turn");
            playersHp.setText("Hp: "+wolf2Int);
            energy.setText("  ");
            wolfAttack();
            partyDeath();
        }
        //If wolf 2 is dead, skip.
        if (turns==6 && wolf2Int<1){
            turns=7;
        }
        //Wolf 3
        if (turns==7 && wolf3Int>0){
            whosTurn.setText("Wolf 3 turn");
            playersHp.setText("Hp: "+wolf3Int);
            energy.setText("  ");
            wolfAttack();
            partyDeath();
        }
        //If wolf 3 is dead, skip.
        if (turns==7 && wolf4Int<1){
            turns=8;
        }
        //Wolf 4
        if (turns==8 && wolf4Int>0){
            whosTurn.setText("Wolf 4 turn");
            playersHp.setText("Hp: "+wolf4Int);
            energy.setText("  ");
            wolfAttack();
            partyDeath();
            turns=0;
        }
        //If wolf 4 is dead, skip.
        if (turns == 8){
            turns=0;
            startNewTurn();
        }
    }

    //When you press block
    private void blockPressed(){

        if(turns==1 && warriorEnergyInt>1){
            warriorEnergyInt=warriorEnergyInt-2;
            currentEnergy=currentEnergy-2;
            warriorBlock+=5;
            energy.setText("Energy: "+warriorEnergyInt);
            block.setText("Block: "+warriorBlock);
        }
        else if(turns==2 && rangerEnergyInt>1){
            rangerEnergyInt=rangerEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+rangerEnergyInt);
            block.setText("Block: "+warriorBlock);
        }
        else if(turns==3 && mageEnergyInt>1){
            mageEnergyInt=mageEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+mageEnergyInt);
            block.setText("Block: "+warriorBlock);
        }
        else if(turns==4 && healerEnergyInt>1){
            healerEnergyInt=healerEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+healerEnergyInt);
            block.setText("Block: "+warriorBlock);
        }
    }

    //When you press attack
    private void attackPressed(){

        if(turns==1 && warriorEnergyInt>1){
            warriorEnergyInt=warriorEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+warriorEnergyInt);
            warriorAttackWolf();
            mobDeath();
            isFightOver();
        }
        else if(turns==2 && rangerEnergyInt>1){
            rangerEnergyInt=rangerEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+rangerEnergyInt);
            rangerAttackWolf();
            mobDeath();
            isFightOver();
        }
        else if(turns==3 && mageEnergyInt>1){
            mageEnergyInt=mageEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+mageEnergyInt);
            mageAttackWolf();
            mobDeath();
            isFightOver();
        }
        else if(turns==4 && healerEnergyInt>1){
            healerEnergyInt=healerEnergyInt-2;
            currentEnergy=currentEnergy-2;
            energy.setText("Energy: "+healerEnergyInt);
            healerAttackWolf();
            mobDeath();
            isFightOver();
        }
    }

    private void warriorAttackWolf() {

        while (true) {
            int target = (int) (Math.random() * 4)+1;

            if (target == 1 && wolf1Int > 0) {
                wolf1Int = wolf1Int - warriorDamage;
                wolf1Hp.setText("Wolf 1: " + wolf1Int);
                break;
            }
            if (target == 2 && wolf2Int > 0) {
                wolf2Int = wolf2Int - warriorDamage;
                wolf2Hp.setText("Wolf 2: " + wolf2Int);
                break;
            }
            if (target == 3 && wolf3Int > 0) {
                wolf3Int = wolf3Int - warriorDamage;
                wolf3Hp.setText("Wolf 3: " + wolf3Int);
                break;
            }
            if (target == 4 && wolf4Int > 0) {
                wolf4Int = wolf4Int - warriorDamage;
                wolf4Hp.setText("Wolf 4: " + wolf4Int);
                break;
            }
        }
    }

    private void mageAttackWolf(){

        while (true) {
            int target = (int) (Math.random() * 4)+1;

            if (target == 1 && wolf1Int > 0) {
                wolf1Int = wolf1Int - mageDamage;
                wolf1Hp.setText("Wolf 1: " + wolf1Int);
                break;
            }
            if (target == 2 && wolf2Int > 0) {
                wolf2Int = wolf2Int - mageDamage;
                wolf2Hp.setText("Wolf 2: " + wolf2Int);
                break;
            }
            if (target == 3 && wolf3Int > 0) {
                wolf3Int = wolf3Int - mageDamage;
                wolf3Hp.setText("Wolf 3: " + wolf3Int);
                break;
            }
            if (target == 4 && wolf4Int > 0) {
                wolf4Int = wolf4Int - mageDamage;
                wolf4Hp.setText("Wolf 4: " + wolf4Int);
                break;
            }
        }
    }

    private void rangerAttackWolf(){
        while (true) {
            int target = (int) (Math.random() * 4)+1;

            if (target == 1 && wolf1Int > 0) {
                wolf1Int = wolf1Int - rangerDamage;
                wolf1Hp.setText("Wolf 1: " + wolf1Int);
                break;
            }
            if (target == 2 && wolf2Int > 0) {
                wolf2Int = wolf2Int - rangerDamage;
                wolf2Hp.setText("Wolf 2: " + wolf2Int);
                break;
            }
            if (target == 3 && wolf3Int > 0) {
                wolf3Int = wolf3Int - rangerDamage;
                wolf3Hp.setText("Wolf 3: " + wolf3Int);
                break;
            }
            if (target == 4 && wolf4Int > 0) {
                wolf4Int = wolf4Int - rangerDamage;
                wolf4Hp.setText("Wolf 4: " + wolf4Int);
                break;
            }
        }
    }

    private void healerAttackWolf(){

        while (true) {
            int target = (int) (Math.random() * 4)+1;

            if (target == 1 && wolf1Int > 0) {
                wolf1Int = wolf1Int - healerDamage;
                wolf1Hp.setText("Wolf 1: " + wolf1Int);
                break;
            }
            if (target == 2 && wolf2Int > 0) {
                wolf2Int = wolf2Int - healerDamage;
                wolf2Hp.setText("Wolf 2: " + wolf2Int);
                break;
            }
            if (target == 3 && wolf3Int > 0) {
                wolf3Int = wolf3Int - healerDamage;
                wolf3Hp.setText("Wolf 3: " + wolf3Int);
                break;
            }
            if (target == 4 && wolf4Int > 0) {
                wolf4Int = wolf4Int - healerDamage;
                wolf4Hp.setText("Wolf 4: " + wolf4Int);
                break;
            }
        }
    }

    private void isFightOver() {
        if (wolf1Int < 1 && wolf2Int < 1 && wolf3Int < 1 && wolf4Int < 1) {
            //Victory screen
            new VictoryScreen();
            dispose();

        }
        if (warriorCurrentHp < 1 && mageCurrentHp < 1 && healerCurrentHp < 1 && rangerCurrentHp < 1) {
            //Game over
            new Hub();
            dispose();
        }
        //else fight not over
    }

    private void wolfAttack() {
        int target = (int) (Math.random() * 4);
        int wolfDamage = (int) (Math.random() * 10) + 15;

        while (true) {
            if (target == 0) {
                if (warriorCurrentHp < 1) {
                    target=1;
                }
                if (warriorCurrentHp >0) {
                    wolfDamage=wolfDamage-warriorBlock;
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
                    wolfDamage=wolfDamage-mageBlock;
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
                    wolfDamage=wolfDamage-rangerBlock;
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
                    wolfDamage=wolfDamage-healerBlock;
                    healerCurrentHp = healerCurrentHp - wolfDamage;
                    player4Hp.setText("Healer:   "+healerCurrentHp);
                    break;
                }
            }
        }
    }

    private void mobDeath(){

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

    private void partyDeath(){

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
            healer.setVisible(false);
        }
    }
    private void importLabels(){
        playersHp = new JLabel("Hp: "+warriorCurrentHp);
        playersHp.setFont(pixelMplus.deriveFont(30f));
        playersHp.setForeground(Color.black);
        Dimension playersHpSize = playersHp.getPreferredSize();
        playersHp.setBounds(30, 600, playersHpSize.width, playersHpSize.height);

        wolf1Hp = new JLabel("Wolf 1: "+ wolf1Int);
        wolf1Hp.setFont(pixelMplus.deriveFont(30f));
        wolf1Hp.setForeground(Color.black);
        Dimension wolf1HpSize = wolf1Hp.getPreferredSize();
        wolf1Hp.setBounds(660, 560, wolf1HpSize.width, wolf1HpSize.height);

        wolf2Hp = new JLabel("Wolf 2: "+ wolf2Int);
        wolf2Hp.setFont(pixelMplus.deriveFont(30f));
        wolf2Hp.setForeground(Color.black);
        Dimension wolf2HpSize = wolf2Hp.getPreferredSize();
        wolf2Hp.setBounds(660, 595, wolf2HpSize.width, wolf2HpSize.height);

        wolf3Hp = new JLabel("Wolf 3: "+ wolf3Int);
        wolf3Hp.setFont(pixelMplus.deriveFont(30f));
        wolf3Hp.setForeground(Color.black);
        Dimension wolf3HpSize = wolf3Hp.getPreferredSize();
        wolf3Hp.setBounds(660, 630, wolf3HpSize.width, wolf3HpSize.height);

        wolf4Hp = new JLabel("Wolf 4: "+ wolf4Int);
        wolf4Hp.setFont(pixelMplus.deriveFont(30f));
        wolf4Hp.setForeground(Color.black);
        Dimension wolf4HpSize = wolf4Hp.getPreferredSize();
        wolf4Hp.setBounds(660, 665, wolf4HpSize.width, wolf4HpSize.height);

        player1Hp = new JLabel("Warrior: "+ warriorCurrentHp);
        player1Hp.setFont(pixelMplus.deriveFont(30f));
        player1Hp.setForeground(Color.black);
        Dimension player1HpSize = player1Hp.getPreferredSize();
        player1Hp.setBounds(430, 560, player1HpSize.width, player1HpSize.height);

        player2Hp = new JLabel("Mage:    "+ mageCurrentHp);
        player2Hp.setFont(pixelMplus.deriveFont(30f));
        player2Hp.setForeground(Color.black);
        Dimension player2HpSize = player1Hp.getPreferredSize();
        player2Hp.setBounds(430, 595, player2HpSize.width, player2HpSize.height);

        player3Hp = new JLabel("Ranger:  "+ rangerCurrentHp);
        player3Hp.setFont(pixelMplus.deriveFont(30f));
        player3Hp.setForeground(Color.black);
        Dimension player3HpSize = player3Hp.getPreferredSize();
        player3Hp.setBounds(430, 630, player3HpSize.width, player3HpSize.height);

        player4Hp = new JLabel("Healer:  "+ healerCurrentHp);
        player4Hp.setFont(pixelMplus.deriveFont(30f));
        player4Hp.setForeground(Color.black);
        Dimension player4HpSize = player4Hp.getPreferredSize();
        player4Hp.setBounds(430, 665, player4HpSize.width, player4HpSize.height);

        energy = new JLabel("Energy: "+warriorEnergyInt);
        energy.setFont(pixelMplus.deriveFont(30f));
        energy.setForeground(Color.black);
        Dimension energySize = energy.getPreferredSize();
        energy.setBounds(30, 640, energySize.width, energySize.height);

        block = new JLabel("Block: "+warriorBlock);
        block.setFont(pixelMplus.deriveFont(30f));
        block.setForeground(Color.black);
        Dimension blockSize = energy.getPreferredSize();
        block.setBounds(30, 670, blockSize.width, blockSize.height);

        whosTurn = new JLabel("Warrior's turn");
        whosTurn.setFont(pixelMplus.deriveFont(30f));
        whosTurn.setForeground(Color.black);
        whosTurn.setBackground(Color.blue);
        Dimension whoSize = whosTurn.getPreferredSize();
        //whosTurn.setMaximumSize(new Dimension(whoSize.width+100,whoSize.height+100));
        whosTurn.setBounds(30, 560, whoSize.width, whoSize.height);
    }

    private void importButtons(){
        //Attack button
        attackButton = new JButton("Attack");
        attackButton.setSize(200, 70);
        attackButton.setLocation(840, 555);
        attackButton.setFont(pixelMplus.deriveFont(30f));
        attackButton.setBackground(Color.white);
        attackButton.setBorder(null); //Remove border around button
        attackButton.setFocusPainted(false);//Remove border around text in button

        //Block button
        blockButton = new JButton("Block");
        blockButton.setSize(200, 70);
        blockButton.setLocation(1050, 555);
        blockButton.setFont(pixelMplus.deriveFont(30f));
        blockButton.setBackground(Color.white);
        blockButton.setBorder(null); //Remove border around button
        blockButton.setFocusPainted(false);//Remove border around text in button

        //Item Button
        itemButton = new JButton("Item");
        itemButton.setSize(200, 70);
        itemButton.setLocation(1050, 630);
        itemButton.setFont(pixelMplus.deriveFont(30f));
        itemButton.setBackground(Color.white);
        itemButton.setBorder(null); //Remove border around button
        itemButton.setFocusPainted(false);//Remove border around text in button

        //Skill Button
        skillButton = new JButton("Skill");
        skillButton.setSize(200, 70);
        skillButton.setLocation(840, 630);
        skillButton.setFont(pixelMplus.deriveFont(30f));
        skillButton.setBackground(Color.white);
        skillButton.setBorder(null); //Remove border around button
        skillButton.setFocusPainted(false);//Remove border around text in button

        //End Turn Button
        endTurnButton = new JButton("End turn");
        endTurnButton.setSize(200, 70);
        endTurnButton.setLocation(540, 468);
        endTurnButton.setFont(pixelMplus.deriveFont(30f));
        endTurnButton.setBackground(Color.white);
        endTurnButton.setBorder(null); //Remove border around button
        endTurnButton.setFocusPainted(false);//Remove border around text in button
    }

    private void importPartyGif(){
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

    private void importWolfGif(){
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
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
        } catch (IOException | FontFormatException e) {
        }
    }

    private void hoverEffect() {

        //Attack Hover
        attackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            //Change button color while hovering depending on your current energy.
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(currentEnergy>1) {
                    attackButton.setBackground(Color.lightGray);
                }
                if(currentEnergy<2){
                    attackButton.setBackground(Color.pink);
                }
            }
            //Change back when not hovering over button
            public void mouseExited(java.awt.event.MouseEvent evt) {
                attackButton.setBackground(Color.white);
            }
        });
        //Block Hover
        blockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(currentEnergy>1) {
                    blockButton.setBackground(Color.lightGray);
                }
                if(currentEnergy<2){
                    blockButton.setBackground(Color.pink);
                }
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
        //Skill Hover
        skillButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                skillButton.setBackground(Color.lightGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                skillButton.setBackground(Color.white);
            }
        });

        //End turn Hover
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