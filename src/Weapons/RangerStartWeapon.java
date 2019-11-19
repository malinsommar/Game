package Weapons;

import Game.Ranger;

public class RangerStartWeapon extends Ranger {

    public RangerStartWeapon(){
        String name = "Wodden bow";
        int damage = 5;
        String rarety = "common";
        System.out.println("Ranger got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
