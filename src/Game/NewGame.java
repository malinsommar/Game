package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class NewGame extends JFrame{

    JFrame gameFrame = new JFrame();
    JLabel backStory;
    JLabel backStory2;
    JLabel backStory3;
    JButton startButton;
    Font pixelMplus;
    Font pixelMplus2;

    private JButton forestButton, caveButton; //

    public NewGame()  {

        setLayout(null);
        setSize(1920, 1080);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);


        //Import font
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }

        try {
            pixelMplus2 = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")).deriveFont(100f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {

        }

        //Backstory text
        backStory = new JLabel("This is a backstory. very cool. This is a backstory. very cool.");
        backStory.setFont(pixelMplus);
        backStory.setForeground(Color.white);
        Dimension size = backStory.getPreferredSize();
        backStory.setBounds(170, 50, size.width, size.height);

        backStory2 = new JLabel("This is a backstory. very nice. This is a backstory. very nice.");
        backStory2.setFont(pixelMplus);
        backStory2.setForeground(Color.white);
        Dimension size2 = backStory2.getPreferredSize();
        backStory2.setBounds(170, 80, size2.width, size2.height);

        backStory3 = new JLabel("This is your party.");
        backStory3.setFont(pixelMplus2);
        backStory3.setForeground(Color.white);
        Dimension size3 = backStory3.getPreferredSize();
        backStory3.setBounds(200, 120, size3.width, size3.height);

        //Start Button
        startButton = new JButton("Save the world");
        startButton.setSize(300,100);
        startButton.setLocation(500,550);
        startButton.setFont(pixelMplus);
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.darkGray);
        //startButton.setBorderPainted(false);
        startButton.setBorder(null); //Remove border around button
        startButton.setFocusPainted(false);//Remove border around text in button




        add(startButton);
        add(backStory);
        add(backStory2);
        add(backStory3);

        // ** Start of Party-members **

        //Create a label
        JLabel warrior = new JLabel();
        JLabel ranger = new JLabel();
        JLabel mage = new JLabel();
        JLabel healer = new JLabel();
        
        //Add a picture to the label
        warrior.setIcon(new ImageIcon("warrior.gif"));
        ranger.setIcon(new ImageIcon("ranger.gif"));
        mage.setIcon(new ImageIcon("mage.gif"));
        healer.setIcon(new ImageIcon("healer.gif"));
        
        //Add party-members
        add(warrior);
        add(ranger);
        add(mage);
        add(healer);
        
        //Get size
        Dimension warriorSize = warrior.getPreferredSize();
        Dimension rangerSize = ranger.getPreferredSize();
        Dimension mageSize = mage.getPreferredSize();
        Dimension healerSize = healer.getPreferredSize();
        
        //Set bounds (location and size)
        warrior.setBounds(140, 250, warriorSize.width, warriorSize.height);
        ranger.setBounds(340, 250, rangerSize.width, rangerSize.height);
        mage.setBounds(540, 250, mageSize.width, mageSize.height);
        healer.setBounds(740, 250, healerSize.width, healerSize.height);
        
        // ** End of party-members **

        setVisible(true);
    }
}