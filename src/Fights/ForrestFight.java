package Fights;

import Armor.RangerStartArmor;
import Game.SetStats;
import Game.Warrior;
import Game.musicpick;
import Gametest.Davidtest.HealthBar.HealthBar;
import Weapons.RangerStartWeapon;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ForrestFight extends JFrame{

    Warrior warr = new Warrior();
    SetStats setStats = new SetStats();
    Font pixelMplus;
    JButton attackButton, blockButton, itemButton, skillButton;
    HealthBar healthBar = new HealthBar();
    //JLabel attacked;
    int attackIndex = 0;

    int warriorCurrentHp,mageCurrentHp,healerCurrentHp,rangerCurrentHp;
    int warriorDamage,mageDamage,healerDamage,rangerDamage;




    //Wolfs
    int wolf1Hp = 20;
    int wolf2Hp = 20;
    int wolf3Hp = 20;
    int wolf4Hp = 20;

    int wolfDamage = (int)(Math.random()*5)+10;


    private void fight(){

        boolean bothTeamsAlive = true;

        while(bothTeamsAlive){

            if (wolf1Hp < 1 && wolf2Hp < 1 && wolf3Hp < 1 && wolf4Hp < 1 ){
                bothTeamsAlive=false;
                //Victory screen
                }

        }
    }

    public void importFont() {

        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {


    public void isFightOver() {
        if (enemies[0] < 1 && enemies[1] < 1 && enemies[2] < 1 && enemies[3] < 1) {
            //Victory screen
            String item = "PlateArmor";
            warr.newArmor(item);
        }
        if (warriorCurrentHp < 1 && mageCurrentHp < 1 && healerCurrentHp < 1 && rangerCurrentHp < 1) {
            //Game over
            System.exit(0);
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
        setContentPane(new JLabel(background)); //set background

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

        //Party members
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
        attackButton.setLocation(840, 535);
        attackButton.setFont(pixelMplus);
        attackButton.setBackground(Color.white);
        attackButton.setBorder(null); //Remove border around button
        attackButton.setFocusPainted(false);//Remove border around text in button

        blockButton = new JButton("Block");
        blockButton.setSize(200, 70);
        blockButton.setLocation(1050, 535);
        blockButton.setFont(pixelMplus);
        blockButton.setBackground(Color.white);
        blockButton.setBorder(null); //Remove border around button
        blockButton.setFocusPainted(false);//Remove border around text in button

        itemButton = new JButton("Item");
        itemButton.setSize(200, 70);
        itemButton.setLocation(1050, 610);
        itemButton.setFont(pixelMplus);
        itemButton.setBackground(Color.white);
        itemButton.setBorder(null); //Remove border around button
        itemButton.setFocusPainted(false);//Remove border around text in button

        skillButton = new JButton("Skill");
        skillButton.setSize(200, 70);
        skillButton.setLocation(840, 610);
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
                    String item = "PlateArmor";
                    warr.newArmor(item);
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

    public static class Ranger {

        ArrayList rangerWeapon = new ArrayList();
        ArrayList rangerArmor = new ArrayList();

        public int hp=70;
        public int block=0;
        public int str=0;
        public int crit=15;
        public int dex=5;

        public void setStartEquipment() {
            rangerWeapon.add(new RangerStartWeapon());
            rangerArmor.add(new RangerStartArmor());
        }
        public void printOutStats(){
            System.out.println("Hp: "+hp+"\nArmor: "+block+"\nStrength: "+str+"\n\nCrit chance: "+crit+"%\nDexterity: "+dex);
        }
    }
}