package Weapons;

import Game.Healer;

public class HealerLegendaryWeapon extends Healer {

    public HealerLegendaryWeapon(){
        String name = "Root of the world tree";
        int damage = 11;
        String rarety = "legendary";
        System.out.println("Healer got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}