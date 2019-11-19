package Game;

import Armor.HealerStartArmor;
import Weapons.HealerStartWeapon;

import java.util.ArrayList;

public class Healer {

    ArrayList<Healer> healerWeapon = new ArrayList();
    ArrayList<Healer> healerArmor = new ArrayList();

    public String name;
    public int blockUp;
    public int damage;

    public int hp=100;
    public int block=0;
    public int str=0;
    public int crit=5;
    public int dex=0;

    public void setStartEquipment() {
        healerWeapon.add(new HealerStartWeapon());
        healerArmor.add(new HealerStartArmor());
    }
    public int setHp() {
        int heaHp = hp+healerArmor.get(0).blockUp;
        return heaHp;
    }
    public int setStr() {
        int heaStr = str+healerWeapon.get(0).damage;
        return heaStr;
    }
}
