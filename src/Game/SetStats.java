package Game;

import java.util.ArrayList;

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
}