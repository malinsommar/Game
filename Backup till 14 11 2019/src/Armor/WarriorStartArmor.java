package Armor;

import Game.Warrior;

public class WarriorStartArmor extends Warrior {

    public WarriorStartArmor(){
        String name = "Rusty Armor";
        int blockUp = 5;
        String rarety = "common";
        System.out.println("Warrior got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}