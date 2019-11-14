package Fights;

import java.util.ArrayList;

public class fightOption {
    public int turnOrder = 0;

    public void skills(ArrayList enemies, String spell, int level){

        if (spell == "firestorm"){
            for (int i = 0; i < 4 ; i++) {
                enemies.get(i).equals enemies.get(i) - 5*level;

            }
        }



    }
}
