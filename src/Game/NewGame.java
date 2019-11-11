package Game;

import javax.swing.*;
import java.awt.*;

public class NewGame extends JFrame{

    JFrame gameFrame = new JFrame();
    JLabel backStory;
    JLabel backStory2;
    JLabel backStory3;
    JButton startButton;


    private JButton forestButton, caveButton; //

    public NewGame()  {

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setLayout(new FlowLayout());

        //Background
        ImageIcon background = new ImageIcon("leaves.jpg"); //download image
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


        //Characters
        JPanel magePanel = new JPanel();

        Icon mage = new ImageIcon("mage.gif");
        try {
            setContentPane(new JLabel(mage));

        } catch (Exception e) {
        }

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
        add(forestButton);
        add(caveButton);

        setVisible(true);
    }
}