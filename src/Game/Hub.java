package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Hub implements ActionListener {

    Scanner sc = new Scanner(System.in);
    JFrame frame = new JFrame();
    JButton exitButton = new JButton("Exit game");
    NewGame newGame = new NewGame();



    public Hub(){

        frameMenu();
    }

    //Jframe
    public void frameMenu(){

       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel) frame.getContentPane(); //ett paket man kan lägga in flera lable/Buttons i för att sortera dem.
        panel.setLayout(null);

        JLabel gameName = new JLabel("*SPELETS TITEL*");
        JButton newRunButton = new JButton("New Run");
        JButton tutorialButton = new JButton("Tutorial");

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


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String name = actionEvent.getActionCommand();

        if(name.equals("New Run")){

            frame.dispose();
            newGame.startGame();
        }
        if(name.equals("Tutorial")){

            //Tutorial
        }
        if(name.equals("Exit game")){

            frame.dispose();
            System.exit(0);
        }
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