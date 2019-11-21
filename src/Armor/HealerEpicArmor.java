package Armor;

import Game.Healer;

public class HealerEpicArmor extends Healer {

    public HealerEpicArmor(){
        String name = "Clerics armor";
        int blockUp = 5;
        String rarety = "epic";
        System.out.println("Healer got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}
