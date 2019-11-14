package Game;

import java.lang.reflect.Array;

public class SetStats {

    Warrior warrior = new Warrior();
    Mage mage = new Mage();
    Healer healer = new Healer();
    Ranger ranger = new Ranger();

    public void setStartPartyStat(){

        warrior.setStartEquipment();
        mage.setStartEquipment();
        healer.setStartEquipment();
        ranger.setStartEquipment();

    }
    public void deadParty(){

    }

    public void setParty(){

        String[] party = new String [4];

        party [0]="warrior";
        party [0]="ranger";
        party [0]="mage";
        party [0]="healer";

    }
}