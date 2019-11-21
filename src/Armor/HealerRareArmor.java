package Armor;

import Game.Healer;

public class HealerRareArmor extends Healer {

    public HealerRareArmor(){
        String name = "Priests robe";
        int blockUp = 2;
        String rarety = "rare";
        System.out.println("Healer got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}
