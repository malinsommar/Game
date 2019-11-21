package Armor;

import Game.Warrior;

public class WarriorEpicArmor extends Warrior {

    public WarriorEpicArmor(){
        String name = "Hardened Armor";
        int blockUp = 9;
        String rarety = "epic";
        System.out.println("Warrior got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}
