package Weapons;

import Game.Ranger;

public class RangerEpicWeapon extends Ranger {

    public RangerEpicWeapon(){
        String name = "Dragonslayer's bow";
        int damage = 11;
        String rarety = "epic";
        System.out.println("Ranger got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
