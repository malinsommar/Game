package Armor;

import Game.Healer;

public class HealerStartArmor extends Healer {

    public HealerStartArmor(){
        String name = "Cloth scraps";
        int blockUp = 0;
        String rarety = "common";
        System.out.println("Healer got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}
