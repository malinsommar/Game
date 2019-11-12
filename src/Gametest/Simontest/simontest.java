package Gametest.Simontest;

import javafx.scene.canvas.GraphicsContext;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

public class simontest extends JFrame{

    JFrame testFrame = new JFrame();

    public simontest() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        ImageIcon picShop = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\shopk.jpg");//download cave image
        setContentPane(new JLabel(picShop)); //assign background
        Icon mage = new ImageIcon("mage.gif");
        add(new JLabel(mage));
        */

        //BufferedImage mage2 = ImageIO.read(new File("mage.gif"));//funkar inte
        //mage2.getGraphics().drawImage(mage2 ,500, 500, null);//funkar inte

        
        /* Create an ARGB BufferedImage */

        BufferedImage mage2 = ImageIO.read((getClass().getResource("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\cave.jpg")));
        Graphics g = mage2.getGraphics();
        g.drawImage(mage2, 0, 0, null);


        setLayout(new FlowLayout()); //Default layout
        setSize(1920, 1080);

        setVisible(true);

    }
        public static void main (String[]args) throws IOException {

        new simontest();

    }
}
