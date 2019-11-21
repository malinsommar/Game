package Game;

import Armor.RangerStartArmor;
import Weapons.RangerStartWeapon;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;

public class Ranger {

    ArrayList<Ranger> rangerWeapon = new ArrayList();
    ArrayList<Ranger> rangerArmor = new ArrayList();

    public int blockUp;
    public int damage;

    public int hp=70;
    public int block=0;
    public int str=0;
    public int crit=15;
    public int dex=5;

    public void setStartEquipment() {
        rangerWeapon.add(new RangerStartWeapon());
        rangerArmor.add(new RangerStartArmor());
    }

    public int setHp() {
        int rangHp = hp+rangerArmor.get(0).blockUp;
        return rangHp;
    }
    public int setStr() {
        int rangStr = str+rangerWeapon.get(0).damage;
        return rangStr;
    }
}