package Game;

import Armor.WarriorStartArmor;
import Weapons.WarriorStartWeapon;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Warrior {

    Scanner sc = new Scanner(System.in);
    Font pixelMplus;
    ArrayList<Warrior> warriorWeapon = new ArrayList();
    ArrayList<Warrior> warriorArmor = new ArrayList();

    public String name;
    public int blockUp;
    public int rarety;

    public int hp = 150;
    public int block = 0;
    public int str = 5;
    public int inte = 0;
    public int crit = 5;
    public int dex = 0;

    public void setStartEquipment() {
        warriorWeapon.add(new WarriorStartWeapon());
        warriorArmor.add(new WarriorStartArmor());
    }

    public void printOutStats() {
        System.out.println("Hp: " + hp + "\nArmor: " + block + "\nStrength: " + str + "\nIntelligence: " + inte + "\nCrit chance: " + crit + "%\nDexterity: " + dex);
    }

    public void newArmor(String item) {

        JFrame itemFrame = new JFrame();
        itemFrame.setLayout(null);
        itemFrame.setSize(200, 100);
        itemFrame.setTitle("New Item found!");
        importFont();

        JButton yes = new JButton("Yes");
        yes.setLocation(30,60);
        yes.setFont(pixelMplus);

        JButton no = new JButton("No");
        no.setLocation(60,60);
        no.setFont(pixelMplus);

        JLabel text = new JLabel("Do you want to replace warrior's " + warriorArmor.get(0).name + " with " + item + "?");
        text.setFont(pixelMplus);
        Dimension size = text.getPreferredSize();
        text.setBounds(350, 10, size.width, size.height);

        itemFrame.setVisible(true);

        int choice = sc.nextInt(); //detta ska vara en knapp senare
        if (choice == 1) {
            warriorArmor.remove(0);
            //warriorArmor.add(new item);
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
}