package Gametest;

import javax.swing.*;
import java.awt.*;

public class simontest extends JFrame{

    JFrame testFrame = new JFrame();

    public simontest(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon picShop = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\shopk.jpg");//download cave image
        setContentPane(new JLabel(picShop)); //assign background

        setLayout(new FlowLayout()); //Default layout
        setSize(1920, 1080);
        setVisible(true);

    }
        public static void main (String[]args){

        new simontest();

    }
}
