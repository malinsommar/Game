package Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shop extends JFrame {

    Inventory inv = new Inventory();

    private Font pixelMplus;
    private JButton back, potion1, potion2, potion3, potion4, potion5, potion6, potion7, potion8, potion9, potion10, potion11, potion12;
    private JButton healerWeapon1, healerWeapon2, healerWeapon3, warriorWeapon1, warriorWeapon2, warriorWeapon3, rangerWeapon1, rangerWeapon2, rangerWeapon3, mageWeapon1, mageWeapon2, mageWeapon3;
    private JButton healerArmor1, healerArmor2, healerArmor3, warriorArmor1, warriorArmor2, warriorArmor3, rangerArmor1, rangerArmor2, rangerArmor3, mageArmor1, mageArmor2, mageArmor3;

    private JLabel currentAction, goldLabel, health, block, energy, strength, warrior, healer, ranger, mage;

    private int currentGold=inv.gold;

    public Shop(){
        super("Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1920, 1080);
        setBackground(Color.white);
        musicpick.musicStart("shop", "music");

        importFont();
        addButtons();
        addLabels();
        hoverEffect();

        add(back);
        add(currentAction);
        add(goldLabel);
        add(health);
        add(block);
        add(energy);
        add(strength);
        add(potion1);
        add(potion2);
        add(potion3);
        add(potion4);
        add(potion5);
        add(potion6);
        add(potion7);
        add(potion8);
        add(potion9);
        add(potion10);
        add(potion11);
        add(potion12);
        add(warriorArmor1);
        add(warriorArmor2);
        add(warriorArmor3);
        add(warriorWeapon1);
        add(warriorWeapon2);
        add(warriorWeapon3);
        add(rangerArmor1);
        add(rangerArmor2);
        add(rangerArmor3);
        add(rangerWeapon1);
        add(rangerWeapon2);
        add(rangerWeapon3);
        add(mageArmor1);
        add(mageArmor2);
        add(mageArmor3);
        add(mageWeapon1);
        add(mageWeapon2);
        add(mageWeapon3);
        add(healerArmor1);
        add(healerArmor2);
        add(healerArmor3);
        add(healerWeapon1);
        add(healerWeapon2);
        add(healerWeapon3);

        add(warrior);
        add(mage);
        add(healer);
        add(ranger);

        //ActionListeners
        back.addActionListener(e -> dispose());
        back.addActionListener(e -> new Hub());

        potion1.addActionListener(e-> buyPotion(1));
        potion2.addActionListener(e-> buyPotion(2));
        potion3.addActionListener(e-> buyPotion(3));
        potion4.addActionListener(e-> buyPotion(4));
        potion5.addActionListener(e-> buyPotion(5));
        potion6.addActionListener(e-> buyPotion(6));
        potion7.addActionListener(e-> buyPotion(7));
        potion8.addActionListener(e-> buyPotion(8));
        potion9.addActionListener(e-> buyPotion(9));
        potion10.addActionListener(e-> buyPotion(10));
        potion11.addActionListener(e-> buyPotion(11));
        potion12.addActionListener(e-> buyPotion(12));

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    public void buyPotion(int index){

        if (index==1 && currentGold>9){
            inv.addPotion(1);
            inv.gold-=10;
            currentGold-=10;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a minor health potion");
        }
        else if (index==2 && currentGold>19){
            inv.addPotion(2);
            inv.gold-=20;
            currentGold-=20;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a lesser health potion");

        }
        else if (index==3 && currentGold>29){
            inv.addPotion(3);
            inv.gold-=30;
            currentGold-=30;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a major health potion");
        }
        else if (index==4 && currentGold>9){
            inv.addPotion(4);
            inv.gold-=10;
            currentGold-=10;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a minor block potion");
        }
        else if (index==5 && currentGold>19){
            inv.addPotion(5);
            inv.gold-=20;
            currentGold-=20;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a lesser block potion");
        }
        else if (index==6 && currentGold>29){
            inv.addPotion(6);
            inv.gold-=30;
            currentGold-=30;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a major block potion");
        }
        else if (index==7 && currentGold>9){
            inv.addPotion(7);
            inv.gold-=10;
            currentGold-=10;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a minor energy potion");
        }
        else if (index==8 && currentGold>19){
            inv.addPotion(8);
            inv.gold-=20;
            currentGold-=20;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a lesser energy potion");
        }
        else if (index==9 && currentGold>29){
            inv.addPotion(9);
            inv.gold-=30;
            currentGold-=30;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a major energy potion");
        }
        else if (index==10 && currentGold>9){
            inv.addPotion(10);
            inv.gold-=10;
            currentGold-=10;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a minor strength potion");
        }
        else if (index==11 && currentGold>19){
            inv.addPotion(11);
            inv.gold-=20;
            currentGold-=20;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a lesser strength potion");
        }
        else if (index==12 && currentGold>29){
            inv.addPotion(12);
            inv.gold-=30;
            currentGold-=30;
            goldLabel.setText("Gold: "+currentGold);
            currentAction.setText("You bought a major strength potion");
        }
        else{
            currentAction.setText("Shopkeeper: You cant afford that!");
        }
    }

    public void addLabels(){

        currentAction = new JLabel("Shopkeeper: Are you gonna buy something or what?             ");
        currentAction.setFont((pixelMplus.deriveFont(30f)));
        currentAction.setForeground(Color.black);
        Dimension currentActionSize = currentAction.getPreferredSize();
        currentAction.setBounds(40, 550, currentActionSize.width, currentActionSize.height);

        goldLabel = new JLabel("Gold: "+currentGold);
        goldLabel.setFont((pixelMplus.deriveFont(30f)));
        goldLabel.setForeground(Color.orange);
        Dimension goldLabelSize = goldLabel.getPreferredSize();
        goldLabel.setBounds(20, 20, goldLabelSize.width, goldLabelSize.height);

        health = new JLabel("Health");
        health.setFont((pixelMplus.deriveFont(30f)));
        health.setForeground(Color.black);
        Dimension healthSize = health.getPreferredSize();
        health.setBounds(955, 50, healthSize.width, healthSize.height);

        block = new JLabel("Block");
        block.setFont((pixelMplus.deriveFont(30f)));
        block.setForeground(Color.black);
        Dimension blockSize = block.getPreferredSize();
        block.setBounds(955, 200, blockSize.width, blockSize.height);

        energy = new JLabel("Energy");
        energy.setFont((pixelMplus.deriveFont(30f)));
        energy.setForeground(Color.black);
        Dimension energySize = health.getPreferredSize();
        energy.setBounds(955, 350, energySize.width, energySize.height);

        strength = new JLabel("Strength");
        strength.setFont((pixelMplus.deriveFont(30f)));
        strength.setForeground(Color.black);
        Dimension strengthSize = strength.getPreferredSize();
        strength.setBounds(950, 500, strengthSize.width, strengthSize.height);

        warrior = new JLabel("Warrior");
        warrior.setFont((pixelMplus.deriveFont(40f)));
        warrior.setForeground(Color.black);
        Dimension warriorSize = warrior.getPreferredSize();
        warrior.setBounds(200, 100, warriorSize.width, warriorSize.height);

        mage = new JLabel("Mage");
        mage.setFont((pixelMplus.deriveFont(40f)));
        mage.setForeground(Color.black);
        Dimension mageSize = mage.getPreferredSize();
        mage.setBounds(607, 100, mageSize.width, mageSize.height);

        ranger = new JLabel("Ranger");
        ranger.setFont((pixelMplus.deriveFont(40f)));
        ranger.setForeground(Color.black);
        Dimension rangerSize = ranger.getPreferredSize();
        ranger.setBounds(210, 320, rangerSize.width, rangerSize.height);

        healer = new JLabel("Healer");
        healer.setFont((pixelMplus.deriveFont(40f)));
        healer.setForeground(Color.black);
        Dimension healerSize = healer.getPreferredSize();
        healer.setBounds(585, 320, healerSize.width, healerSize.height);
    }

    private void addButtons(){

        back = new JButton("Exit shop");
        back.setSize(300, 100);
        back.setLocation(20, 600);
        back.setFont(pixelMplus.deriveFont(30f));
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBorder(null);
        back.setFocusPainted(false);

        //Minor Health Potion
        potion1 = new JButton(inv.minorHealthGif);
        potion1.setSize(41, 62);
        potion1.setLocation(900, 100);
        potion1.setBackground(Color.white);
        potion1.setBorder(null);
        potion1.setFocusPainted(false);

        //Lesser Health Potion
        potion2 = new JButton(inv.lesserHealthGif);
        potion2.setSize(46, 62);
        potion2.setLocation(970, 100);
        potion2.setBackground(Color.white);
        potion2.setBorder(null);
        potion2.setFocusPainted(false);

        //Major Health Potion
        potion3 = new JButton(inv.majorHealthGif);
        potion3.setSize(55, 64);
        potion3.setLocation(1050, 100);
        potion3.setBackground(Color.white);
        potion3.setBorder(null);
        potion3.setFocusPainted(false);

        //Minor Block Potion
        potion4 = new JButton(inv.minorBlockGif);
        potion4.setSize(42, 63);
        potion4.setLocation(900, 250);
        potion4.setBackground(Color.white);
        potion4.setBorder(null);
        potion4.setFocusPainted(false);

        //Lesser Block Potion
        potion5 = new JButton(inv.lesserBlockGif);
        potion5.setSize(47, 63);
        potion5.setLocation(970, 250);
        potion5.setBackground(Color.white);
        potion5.setBorder(null);
        potion5.setFocusPainted(false);

        //Major Block Potion
        potion6 = new JButton(inv.majorBlockGif);
        potion6.setSize(59, 64);
        potion6.setLocation(1050, 250);
        potion6.setBackground(Color.white);
        potion6.setBorder(null);
        potion6.setFocusPainted(false);

        //Minor Energy Potion
        potion7 = new JButton(inv.minorEnergyGif);
        potion7.setSize(41, 63);
        potion7.setLocation(900, 400);
        potion7.setBackground(Color.white);
        potion7.setBorder(null);
        potion7.setFocusPainted(false);

        //Lesser Energy Potion
        potion8 = new JButton(inv.lesserEnergyGif);
        potion8.setSize(46, 63);
        potion8.setLocation(970, 400);
        potion8.setBackground(Color.white);
        potion8.setBorder(null);
        potion8.setFocusPainted(false);

        //Major Energy Potion
        potion9 = new JButton(inv.majorEnergyGif);
        potion9.setSize(59, 64);
        potion9.setLocation(1050, 400);
        potion9.setBackground(Color.white);
        potion9.setBorder(null);
        potion9.setFocusPainted(false);

        //Minor Strength Potion
        potion10 = new JButton(inv.minorStrGif);
        potion10.setSize(38, 63);
        potion10.setLocation(900, 550);
        potion10.setBackground(Color.white);
        potion10.setBorder(null);
        potion10.setFocusPainted(false);

        //Lesser Energy Potion
        potion11 = new JButton(inv.lesserStrGif);
        potion11.setSize(42, 63);
        potion11.setLocation(970, 550);
        potion11.setBackground(Color.white);
        potion11.setBorder(null);
        potion11.setFocusPainted(false);

        //Major Energy Potion
        potion12 = new JButton(inv.majorStrGif);
        potion12.setSize(53, 64);
        potion12.setLocation(1050, 550);
        potion12.setBackground(Color.white);
        potion12.setBorder(null);
        potion12.setFocusPainted(false);
        //Warrior stuff
        warriorArmor1 = new JButton(inv.warriorRareArmorPic);
        warriorArmor1.setSize(53, 64);
        warriorArmor1.setLocation(175, 155);
        warriorArmor1.setBackground(Color.white);
        warriorArmor1.setBorder(null);
        warriorArmor1.setFocusPainted(false);

        warriorArmor2 = new JButton(inv.warriorEpicArmorPic);
        warriorArmor2.setSize(53, 64);
        warriorArmor2.setLocation(235, 155);
        warriorArmor2.setBackground(Color.white);
        warriorArmor2.setBorder(null);
        warriorArmor2.setFocusPainted(false);

        warriorArmor3 = new JButton(inv.warriorLegendaryArmorPic);
        warriorArmor3.setSize(53, 64);
        warriorArmor3.setLocation(295, 155);
        warriorArmor3.setBackground(Color.white);
        warriorArmor3.setBorder(null);
        warriorArmor3.setFocusPainted(false);

        warriorWeapon1 = new JButton(inv.warriorRareWeaponPic);
        warriorWeapon1.setSize(53, 64);
        warriorWeapon1.setLocation(175, 225);
        warriorWeapon1.setBackground(Color.white);
        warriorWeapon1.setBorder(null);
        warriorWeapon1.setFocusPainted(false);

        warriorWeapon2 = new JButton(inv.warriorEpicWeaponPic);
        warriorWeapon2.setSize(53, 64);
        warriorWeapon2.setLocation(235, 225);
        warriorWeapon2.setBackground(Color.white);
        warriorWeapon2.setBorder(null);
        warriorWeapon2.setFocusPainted(false);

        warriorWeapon3 = new JButton(inv.warriorLegendaryWeaponPic);
        warriorWeapon3.setSize(53, 64);
        warriorWeapon3.setLocation(295, 225);
        warriorWeapon3.setBackground(Color.white);
        warriorWeapon3.setBorder(null);
        warriorWeapon3.setFocusPainted(false);

        rangerArmor1 = new JButton(inv.rangerRareArmorPic);
        rangerArmor1.setSize(53, 64);
        rangerArmor1.setLocation(175, 375);
        rangerArmor1.setBackground(Color.white);
        rangerArmor1.setBorder(null);
        rangerArmor1.setFocusPainted(false);

        rangerArmor2 = new JButton(inv.rangerEpicArmorPic);
        rangerArmor2.setSize(53, 64);
        rangerArmor2.setLocation(235, 375);
        rangerArmor2.setBackground(Color.white);
        rangerArmor2.setBorder(null);
        rangerArmor2.setFocusPainted(false);

        rangerArmor3 = new JButton(inv.rangerLegendaryArmorPic);
        rangerArmor3.setSize(53, 64);
        rangerArmor3.setLocation(295, 375);
        rangerArmor3.setBackground(Color.white);
        rangerArmor3.setBorder(null);
        rangerArmor3.setFocusPainted(false);

        rangerWeapon1 = new JButton(inv.rangerRareWeaponPic);
        rangerWeapon1.setSize(53, 64);
        rangerWeapon1.setLocation(175, 445);
        rangerWeapon1.setBackground(Color.white);
        rangerWeapon1.setBorder(null);
        rangerWeapon1.setFocusPainted(false);

        rangerWeapon2 = new JButton(inv.rangerEpicWeaponPic);
        rangerWeapon2.setSize(53, 64);
        rangerWeapon2.setLocation(235, 445);
        rangerWeapon2.setBackground(Color.white);
        rangerWeapon2.setBorder(null);
        rangerWeapon2.setFocusPainted(false);

        rangerWeapon3 = new JButton(inv.rangerLegendaryWeaponPic);
        rangerWeapon3.setSize(53, 64);
        rangerWeapon3.setLocation(295, 445);
        rangerWeapon3.setBackground(Color.white);
        rangerWeapon3.setBorder(null);
        rangerWeapon3.setFocusPainted(false);

        mageArmor1 = new JButton(inv.mageRareArmorPic);
        mageArmor1.setSize(53, 64);
        mageArmor1.setLocation(555, 155);
        mageArmor1.setBackground(Color.white);
        mageArmor1.setBorder(null);
        mageArmor1.setFocusPainted(false);

        mageArmor2 = new JButton(inv.mageEpicArmorPic);
        mageArmor2.setSize(53, 64);
        mageArmor2.setLocation(615, 155);
        mageArmor2.setBackground(Color.white);
        mageArmor2.setBorder(null);
        mageArmor2.setFocusPainted(false);

        mageArmor3 = new JButton(inv.mageLegendaryArmorPic);
        mageArmor3.setSize(53, 64);
        mageArmor3.setLocation(675, 155);
        mageArmor3.setBackground(Color.white);
        mageArmor3.setBorder(null);
        mageArmor3.setFocusPainted(false);

        mageWeapon1 = new JButton(inv.mageRareWeaponPic);
        mageWeapon1.setSize(53, 64);
        mageWeapon1.setLocation(555, 225);
        mageWeapon1.setBackground(Color.white);
        mageWeapon1.setBorder(null);
        mageWeapon1.setFocusPainted(false);

        mageWeapon2 = new JButton(inv.mageEpicWeaponPic);
        mageWeapon2.setSize(53, 64);
        mageWeapon2.setLocation(615, 225);
        mageWeapon2.setBackground(Color.white);
        mageWeapon2.setBorder(null);
        mageWeapon2.setFocusPainted(false);

        mageWeapon3 = new JButton(inv.mageLegendaryWeaponPic);
        mageWeapon3.setSize(53, 64);
        mageWeapon3.setLocation(675, 225);
        mageWeapon3.setBackground(Color.white);
        mageWeapon3.setBorder(null);
        mageWeapon3.setFocusPainted(false);

        healerArmor1 = new JButton(inv.healerRareArmorPic);
        healerArmor1.setSize(53, 64);
        healerArmor1.setLocation(555, 375);
        healerArmor1.setBackground(Color.white);
        healerArmor1.setBorder(null);
        healerArmor1.setFocusPainted(false);

        healerArmor2 = new JButton(inv.healerEpicArmorPic);
        healerArmor2.setSize(53, 64);
        healerArmor2.setLocation(615, 375);
        healerArmor2.setBackground(Color.white);
        healerArmor2.setBorder(null);
        healerArmor2.setFocusPainted(false);

        healerArmor3 = new JButton(inv.healerLegendaryArmorPic);
        healerArmor3.setSize(53, 64);
        healerArmor3.setLocation(675, 375);
        healerArmor3.setBackground(Color.white);
        healerArmor3.setBorder(null);
        healerArmor3.setFocusPainted(false);

        healerWeapon1 = new JButton(inv.healerRareWeaponPic);
        healerWeapon1.setSize(53, 64);
        healerWeapon1.setLocation(555, 445);
        healerWeapon1.setBackground(Color.white);
        healerWeapon1.setBorder(null);
        healerWeapon1.setFocusPainted(false);

        healerWeapon2 = new JButton(inv.healerEpicWeaponPic);
        healerWeapon2.setSize(53, 64);
        healerWeapon2.setLocation(615, 445);
        healerWeapon2.setBackground(Color.white);
        healerWeapon2.setBorder(null);
        healerWeapon2.setFocusPainted(false);

        healerWeapon3 = new JButton(inv.healerLegendaryWeaponPic);
        healerWeapon3.setSize(53, 64);
        healerWeapon3.setLocation(675, 445);
        healerWeapon3.setBackground(Color.white);
        healerWeapon3.setBorder(null);
        healerWeapon3.setFocusPainted(false);
    }

    private void hoverEffect() {

        //Minor health potion
        potion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Minor health potion, heals 10hp.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You gonna buy something?");
            }
        });
        //Lesser health potion
        potion2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Lesser health potion, heals 30hp.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: These are great prizes!");
            }
        });
        //Major health potion
        potion3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Major health potion, heals 60hp.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Take a look at my wares!");
            }
        });
        //Minor energy potion
        potion4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Minor block potion, blocks grants 5 block.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You gonna buy something?");
            }
        });
        //Lesser energy potion
        potion5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Lesser block potion, grants 20 block.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: ...?");
            }
        });
        //Major energy potion
        potion6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Major block potion, grants 50 block.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Come on! I haven't got all day.");
            }
        });
        //Minor energy potion
        potion7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Minor energy potion, grants 2 energy.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: These are the finest wares in town!");
            }
        });
        potion8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Lesser energy potion, grants 5 energy.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Lets do some business!");
            }
        });
        potion9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Major energy potion, grants 10 energy.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: It's getting late...");
            }
        });
        potion10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Minor strength potion, grants 5 strength.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Do you have any gold? ");
            }
        });
        potion11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Lesser strength potion, grants 20 strength.");

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: I got an endless supply of potions!");
            }
        });
        potion12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Major strength potion, grants 35 strength.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Buy something, you wont regret it!");
            }
        });
        //Warrior's things
        warriorArmor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shiny Armor, Block: 6.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: That's a real shiny armor!");
            }
        });
        warriorArmor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Hardened Armor, Block: 10.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You like that one?");
            }
        });
        warriorArmor3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Royal Enchanted Armor, Block: 20.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: No need to worry in that armor!");
            }
        });
        warriorWeapon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Iron sword, Attack: 8.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Give it a swing!");
            }
        });
        warriorWeapon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Tempered steel blade, Attack: 15.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: I take good care of my wares!");
            }
        });
        warriorWeapon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Sword of a thousand truths, Attack: 27.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Watch out, it's sharp!");
            }
        });
        //Mage
        mageArmor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Mooncloth robe, Block: 2.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You would look great in that one!");
            }
        });
        mageArmor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Enchanted robe, Block: 4.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Feel how soft it is!");
            }
        });
        mageArmor3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Robe of the archmage, Block: 6.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Don't you love the look of that one?");
            }
        });
        mageWeapon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Ivory fire wand, Attack: 7.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You wanna try it?");
            }
        });
        mageWeapon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Enchanted mana wand, Attack: 15.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: If you wanna try it, do it outside..");
            }
        });
        mageWeapon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Pyromaniac's tinderbox, Attack: 30.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: That's the most powerful weapon i know of.");
            }
        });
        //Healer
        healerArmor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Priests robe, Block: 2.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: I love the colors on that one.");
            }
        });
        healerArmor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Clerics armor, Block: 8.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: That's a nice armor.");
            }
        });
        healerArmor3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Plate armor of Parl'ont the crusader, Block: 13.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Do you want to try it on?");
            }
        });
        healerWeapon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Stick of truth, Attack: 7.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Such a nice staff.");
            }
        });
        healerWeapon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Cleric's blessed walking stick, Attack: 13.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You can use it as a walking stick!");
            }
        });
        healerWeapon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Root of the world tree, Attack: 23.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: I wonder if it's really from that tree..?");
            }
        });
        //Ranger
        rangerArmor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Fine leather armor, Block: 5.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: The leatherworker made that from my own cow!");
            }
        });
        rangerArmor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Elven leather armor, Block: 11.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: The elves are kind of #$@&%* actually..");
            }
        });
        rangerArmor3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Demonskin armor, Block: 20.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: Does demons really have skin..?");
            }
        });
        rangerWeapon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Elven bow, Attack: 8.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: The elves are great weapon makers!");
            }
        });
        rangerWeapon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Dragonslayer's bow, Attack: 16.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: The tales say it killed the last dragon!");
            }
        });
        rangerWeapon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                currentAction.setText("Bullseye's bow, Attack: 26.");

            }public void mouseExited(java.awt.event.MouseEvent evt) {
                currentAction.setText("Shopkeeper: You can hit anything with that bow!");
            }
        });
    }

    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
        } catch (IOException | FontFormatException e) {
        }
    }
}