package Weapons;

import Game.Warrior;

public class WarriorRareWeapon extends Warrior {

    public WarriorRareWeapon(){

        String name = "Iron sword";
        int damage = 8;
        String rarety = "rare";
        System.out.println("Warrior got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}