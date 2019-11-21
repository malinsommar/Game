package Game;

import Armor.MageStartArmor;
import Weapons.MageStartWeapon;

import java.util.ArrayList;

public class Mage{

    ArrayList<Mage> mageWeapon = new ArrayList();
    ArrayList<Mage> mageArmor = new ArrayList();

    public int blockUp; //The block from the armor
    public int damage; //The damage from the weapon

    public int hp=100;
    public int block=0;
    public int str=0;
    int crit=5;
    public int dex=0;

    public void setStartEquipment() {
        mageWeapon.add(new MageStartWeapon());
        mageArmor.add(new MageStartArmor());
    }

    public int setHp() {
        int mageHp = hp+mageArmor.get(0).blockUp;
        return mageHp;
    }
    public int setStr() {
        int mageStr = str+mageWeapon.get(0).damage;
        return mageStr;
    }

}