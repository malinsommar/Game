package Weapons;

import Game.Warrior;

public class WarriorEpicWeapon extends Warrior {

    public WarriorEpicWeapon(){

        String name = "Tempered steel blade";
        int damage = 11;
        String rarety = "epic";
        System.out.println("Warrior got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}