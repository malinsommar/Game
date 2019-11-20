package Armor;

import Game.Mage;

public class MageEpicArmor extends Mage {

    public MageEpicArmor(){
        String name = "Enchanted robe";
        int blockUp = 4;
        String rarety = "epic";
        System.out.println("Mage got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}