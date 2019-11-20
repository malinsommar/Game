package Armor;

import Game.Healer;

public class HealerLegendaryArmor extends Healer {

    public HealerLegendaryArmor(){
        String name = "Plate armor of parl'ont the crusader";
        int blockUp = 9;
        String rarety = "legendary";
        System.out.println("Healer got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}
