package Armor;

import Game.Ranger;

public class RangerEpicArmor extends Ranger {

    public RangerEpicArmor(){
        String name = "Elven leather armor";
        int blockUp = 4;
        String rarety = "epic";
        System.out.println("Ranger got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
    }
}
