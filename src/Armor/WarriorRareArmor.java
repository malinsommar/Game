package Armor;

import Game.Warrior;

    public class WarriorRareArmor extends Warrior {

        public WarriorRareArmor(){
            String name = "Shiny Armor";
            int blockUp = 7;
            String rarety = "rare";
            System.out.println("Warrior got a "+name+". Block: " + blockUp+". Raraty: "+rarety);
        }
    }
