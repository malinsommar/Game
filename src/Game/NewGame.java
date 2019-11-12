package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class NewGame extends JFrame{

    JFrame gameFrame = new JFrame();
    JLabel backStory;
    JLabel backStory2;
    JLabel backStory3;
    JButton startButton;


    private JButton forestButton, caveButton; //

    public NewGame()  {

        setLayout(null);

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Background
        ImageIcon background = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\Simontest\\shopk.jpg");
        setContentPane(new JLabel(background));

        //Images
        ImageIcon picForest = new ImageIcon("forest.jpg");//download cavern image
        ImageIcon picCave = new ImageIcon("cave.jpg");//download cave image
        forestButton = new JButton(picForest);
        caveButton = new JButton(picCave);

        //Text
        backStory = new JLabel("This is a backstory. very cool. This is a backstory. very cool. This is a backstory. very cool.");
        backStory.setFont(new Font("Courier", Font.BOLD,15));
        backStory.setForeground(Color.black);
        Dimension size = backStory.getPreferredSize();
        backStory.setBounds(350, 100, size.width, size.height);

        backStory2 = new JLabel("This is a backstory. very nice. This is a backstory. very nice. This is a backstory. very cool.");
        backStory2.setFont(new Font("Courier", Font.BOLD,15));
        backStory2.setForeground(Color.black);
        Dimension size2 = backStory2.getPreferredSize();
        backStory2.setBounds(350, 130, size2.width, size2.height);

        backStory3 = new JLabel("This is your party.");
        backStory3.setFont(new Font("Courier", Font.BOLD,60));
        backStory3.setForeground(Color.black);
        Dimension size3 = backStory3.getPreferredSize();
        backStory3.setBounds(400, 175, size3.width, size3.height);

        //Start Button
        startButton = new JButton("Save the world");
        startButton.setSize(300,100);
        startButton.setLocation(500,550);
        startButton.setFont(new Font("Courier", Font.BOLD,27));
        startButton.setBackground(Color.white);

        add(startButton);
        add(backStory);
        add(backStory2);
        add(backStory3);

        //skapar en label
        JLabel warrior = new JLabel();
        JLabel ranger = new JLabel();
        JLabel mage = new JLabel();
        JLabel healer = new JLabel();
        //lägger in en bild i labelen
        warrior.setIcon(new ImageIcon("warrior.gif"));
        ranger.setIcon(new ImageIcon("ranger.gif"));
        mage.setIcon(new ImageIcon("mage.gif"));
        healer.setIcon(new ImageIcon("healer.gif"));
        //lägger in labelen i framen
        add(warrior);
        add(ranger);
        add(mage);
        add(healer);
        //hämtar storlek
        Dimension warriorsize = warrior.getPreferredSize();
        Dimension rangersize = ranger.getPreferredSize();
        Dimension magesize = mage.getPreferredSize();
        Dimension healersize = healer.getPreferredSize();
        //bildens plasering
        warrior.setBounds(100, 100, warriorsize.width, warriorsize.height);
        ranger.setBounds(100, 100, rangersize.width, rangersize.height);
        mage.setBounds(100, 100, magesize.width, magesize.height);
        healer.setBounds(100, 100, healersize.width, healersize.height);

        //add(forestButton);
        //add(caveButton);

        setSize(1920, 1080);

        setVisible(true);
    }
}