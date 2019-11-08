package Game;

import java.util.Scanner;

public class Hub {

    Scanner sc = new Scanner(System.in);

    public Hub(){

        mainMenu();
    }

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
