package Weapons;

import Game.Warrior;

public class WarriorStartWeapon extends Warrior {

    public WarriorStartWeapon(){

        String name = "Wodden sword";
        int damage = 5;
        String rarety = "common";
        System.out.println("Warrior got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}
