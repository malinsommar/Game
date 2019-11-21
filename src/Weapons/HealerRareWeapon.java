package Weapons;

import Game.Healer;

public class HealerRareWeapon extends Healer {

    public HealerRareWeapon(){
        String name = "Cleric's blessed walking stick";
        int damage = 7;
        String rarety = "rare";
        System.out.println("Healer got a "+name+". Damage: " + damage+". Raraty: "+rarety);
    }
}