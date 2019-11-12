package Fights;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ForrestFight extends JFrame{

    Font pixelMplus;
    JButton attackButton;
    JButton blockButton;
    JButton itemButton;
    JButton skillButton;

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
        setTitle("Forrest Fight");
        importFont();

        //Background picture
        ImageIcon background = new ImageIcon("forest.jpg"); //download image
        setContentPane(new JLabel(background)); //set backgrund

        //Wolf Mob gif
        JLabel wolf1 = new JLabel();
        wolf1.setIcon(new ImageIcon("forestMob.gif"));
        Dimension wolfSize = wolf1.getPreferredSize();
        wolf1.setBounds(850, 310, wolfSize.width, wolfSize.height);

        JLabel wolf2 = new JLabel();
        wolf2.setIcon(new ImageIcon("forestMob.gif"));
        wolf2.setBounds(1030, 310, wolfSize.width, wolfSize.height);

        JLabel wolf3 = new JLabel();
        wolf3.setIcon(new ImageIcon("forestMob.gif"));
        wolf3.setBounds(900, 390, wolfSize.width, wolfSize.height);

        JLabel wolf4 = new JLabel();
        wolf4.setIcon(new ImageIcon("forestMob.gif"));
        wolf4.setBounds(1080, 390, wolfSize.width, wolfSize.height);

        //Party members
        JLabel warrior = new JLabel();
        warrior.setIcon(new ImageIcon("warrior.gif"));
        Dimension warriorsize = warrior.getPreferredSize();
        warrior.setBounds(100, 200, warriorsize.width, warriorsize.height);



        //Buttons
        attackButton = new JButton("Attack");
        attackButton.setSize(200, 70);
        attackButton.setLocation(840, 535);
        attackButton.setFont(pixelMplus);
        attackButton.setBackground(Color.white);

        blockButton = new JButton("Block");
        blockButton.setSize(200, 70);
        blockButton.setLocation(1050, 535);
        blockButton.setFont(pixelMplus);
        blockButton.setBackground(Color.white);

        itemButton = new JButton("Item");
        itemButton.setSize(200, 70);
        itemButton.setLocation(1050, 610);
        itemButton.setFont(pixelMplus);
        itemButton.setBackground(Color.white);

        skillButton = new JButton("Skill");
        skillButton.setSize(200, 70);
        skillButton.setLocation(840, 610);
        skillButton.setFont(pixelMplus);
        skillButton.setBackground(Color.white);



        //Add Items
        add(attackButton);
        add(blockButton);
        add(itemButton);
        add(skillButton);
        add(wolf3);
        add(wolf4);
        add(wolf1);
        add(wolf2);
        add(warrior);



        setVisible(true);
    }
}