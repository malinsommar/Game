package Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Shop extends JFrame {

    Inventory inv = new Inventory();

    private Font pixelMplus;
    private JButton back, potion1, potion2, potion3, potion4, potion5, potion6, potion7, potion8, potion9, potion10, potion11, potion12;
    private JLabel currentAction, goldLabel, health, block, energy, strength;

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

        currentAction = new JLabel("Shopkeeper: Are you gonna buy something or what?");
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
    }

    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
        } catch (IOException | FontFormatException e) {
        }
    }
}