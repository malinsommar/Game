package Game;

import Fights.ForrestFight;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class SetStats {

    Warrior warrior = new Warrior();
    Mage mage = new Mage();
    main.Healer healer = new main.Healer();
    ForrestFight.Ranger ranger = new ForrestFight.Ranger();

    public void setStartPartyStat(){

        warrior.setStartEquipment();
        mage.setStartEquipment();
        healer.setStartEquipment();
        ranger.setStartEquipment();

    }

}