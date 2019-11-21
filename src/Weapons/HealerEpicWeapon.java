package Weapons;

import Game.Healer;

public class HealerEpicWeapon extends Healer {

    public HealerEpicWeapon(){
        String name = "Stick of truth";
        int damage = 9;
        String rarety = "Epic";
        System.out.println("Healer got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}