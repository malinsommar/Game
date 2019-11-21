package Weapons;

import Game.Mage;

public class MageStartWeapon extends Mage {

    public MageStartWeapon(){

        String name = "Wooden wand";
        int damage = 5;
        String rarety = "common";
        System.out.println("Mage got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
