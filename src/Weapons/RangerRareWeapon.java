package Weapons;

import Game.Ranger;

public class RangerRareWeapon extends Ranger {

    public RangerRareWeapon(){
        String name = "Elven bow";
        int damage = 8;
        String rarety = "rare";
        System.out.println("Ranger got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
