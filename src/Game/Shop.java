package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Shop extends JFrame {

    Inventory inv = new Inventory();

    Font pixelMplus;
    JButton potion1, potion2, potion3, potion4, potion5, potion6, potion7, potion8, potion9, potion10, potion11, potion12;
    JLabel health, block, energy, strength;

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

        add(health);
        add(block);

        add(potion1);
        add(potion2);
        add(potion3);
        add(potion4);
        add(potion5);
        add(potion6);


        /*ImageIcon background = new ImageIcon("tavern.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund*/

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    public void addLabels(){

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
        energy.setBounds(955, 60, energySize.width, energySize.height);

        strength = new JLabel("Strength");
        strength.setFont((pixelMplus.deriveFont(30f)));
        strength.setForeground(Color.black);
        Dimension strengthSize = health.getPreferredSize();
        strength.setBounds(955, 60, strengthSize.width, strengthSize.height);
    }

    private void addButtons(){

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
        potion7 = new JButton(inv.minorBlockGif);
        potion7.setSize(42, 63);
        potion7.setLocation(900, 250);
        potion7.setBackground(Color.white);
        potion7.setBorder(null);
        potion7.setFocusPainted(false);

        //Lesser Energy Potion
        potion8 = new JButton(inv.lesserBlockGif);
        potion8.setSize(47, 63);
        potion8.setLocation(970, 250);
        potion8.setBackground(Color.white);
        potion8.setBorder(null);
        potion8.setFocusPainted(false);

        //Major Energy Potion
        potion9 = new JButton(inv.majorBlockGif);
        potion9.setSize(59, 64);
        potion9.setLocation(1050, 250);
        potion9.setBackground(Color.white);
        potion9.setBorder(null);
        potion9.setFocusPainted(false);
    }

    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
        } catch (IOException | FontFormatException e) {
        }
    }
}