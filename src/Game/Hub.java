package Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Hub {

    Scanner sc = new Scanner(System.in);
    JFrame frame = new JFrame();



    public Hub(){

        frameMenu();
    }


    //Jframe
    public void frameMenu(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel) frame.getContentPane(); //ett paket man kan lägga in flera lable/Buttons i för att sortera dem.
        panel.setLayout(null);

        JLabel gameName = new JLabel("*SPELETS TITEL*");
        JButton newRunButton = new JButton("New Run");
        JButton tutorialButton = new JButton("Tutorial");
        JButton exitButton = new JButton("Exit game");

        panel.add(gameName);

        Dimension size = gameName.getPreferredSize();
        gameName.setBounds(240, 10, size.width, size.height);  //sätter vart Lable ska vara någonstans. Men fungerar inte när set.layout är med.

        panel.add(newRunButton);
        frame.add(tutorialButton);
        frame.add(exitButton);

        frame.setLayout(new FlowLayout()); //Deafult layout
        frame.setSize(600, 300);
        frame.setVisible(true);
    }

    //Ren Java
    public void mainMenu(){
        //New run, tutorial, exit

        System.out.println("**Spelets Namn**");
        System.out.println("[1] New run");
        System.out.println("[2] Tutorial");
        System.out.println("[2] Exit");

        int menuChoice = sc.nextInt();

        switch (menuChoice){

            case 1:
                //new run

            case 2:
                //Tutorial

            case 3:
                System.out.println("Shutting down...");
                System.exit(0);
        }
    }
}
