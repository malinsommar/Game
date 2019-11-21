package Weapons;

import Game.Healer;

public class HealerStartWeapon extends Healer {

    public HealerStartWeapon(){
        String name = "Wooden staff";
        int damage = 5;
        String rarety = "common";
        System.out.println("Healer got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
