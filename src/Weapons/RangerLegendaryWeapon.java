package Weapons;

import Game.Ranger;

public class RangerLegendaryWeapon extends Ranger {

    public RangerLegendaryWeapon(){
        String name = "Bullseye";
        int damage = 15;
        String rarety = "Legendary";
        System.out.println("Ranger got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}