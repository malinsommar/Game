package Weapons;

import Game.Mage;

public class MageRareWeapon extends Mage {

    public MageRareWeapon(){

        String name = "Ivory fire wand";
        int damage = 7;
        String rarety = "rare";
        System.out.println("Mage got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
