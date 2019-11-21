package Game;

import Armor.WarriorRareArmor;
import Armor.WarriorStartArmor;
import Weapons.WarriorStartWeapon;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Warrior {

    Font pixelMplus;
    ArrayList<Warrior> warriorWeapon = new ArrayList();
    ArrayList<Warrior> warriorArmor = new ArrayList();

    public String name;
    public int blockUp;
    public int damage;
    public int rarity;

    public int hp = 150;
    public int block = 0;
    public int str = 5;

    public void setStartEquipment() {
        warriorWeapon.add(new WarriorStartWeapon());
        warriorArmor.add(new WarriorStartArmor());
    }

    public int setHp() {
        return hp+warriorArmor.get(0).blockUp;
    }

    public int setStr() {
        return str+warriorWeapon.get(0).damage;
    }

    public void newArmor(String item) {

        JFrame itemFrame = new JFrame();
        itemFrame.setLayout(null);
        itemFrame.setSize(200, 100);
        itemFrame.setTitle("New Item found!");
        importFont();

        //Buttons
        JButton yes = new JButton("Yes");
        yes.setLocation(30,60);
        yes.setFont(pixelMplus);

        JButton no = new JButton("No");
        no.setLocation(60,60);
        no.setFont(pixelMplus);

        //Text
        JLabel text = new JLabel("Do you want to replace warrior's " + warriorArmor.get(0).name + " with " + item + "?");
        text.setFont(pixelMplus);
        Dimension size = text.getPreferredSize();
        text.setBounds(350, 10, size.width, size.height);

        //Add all items
        itemFrame.add(no);
        itemFrame.add(yes);
        itemFrame.add(text);

        //Action Listeners
        yes.addActionListener(e -> warriorArmor.remove(0));
        yes.addActionListener(e ->warriorArmor.add(new WarriorRareArmor()));
        yes.addActionListener(e ->itemFrame.dispose());

        no.addActionListener(e ->itemFrame.dispose());

        itemFrame.setVisible(true);

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