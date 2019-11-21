package Weapons;

import Game.Warrior;

public class WarriorLegendaryWeapon extends Warrior {

    public WarriorLegendaryWeapon(){

        String name = "Sword of a thousand truths";
        int damage = 14;
        String rarety = "Legendary";
        System.out.println("Warrior got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}