package Weapons;

import Game.Mage;

public class MageEpicWeapon extends Mage {

    public MageEpicWeapon(){

        String name = "Enchanted mana wand";
        int damage = 9;
        String rarety = "epic";
        System.out.println("Mage got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
