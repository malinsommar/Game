package Game;

import Armor.MageStartArmor;
import Weapons.MageStartWeapon;

import java.util.ArrayList;

public class Mage{

    ArrayList mageWeapon = new ArrayList();
    ArrayList mageArmor = new ArrayList();

    public int hp=100;
    public int block=0;
    public int str=0;
    int crit=5;
    public int dex=0;

    public void setStartEquipment() {
        mageWeapon.add(new MageStartWeapon());
        mageArmor.add(new MageStartArmor());
    }
    public void printOutStats(){
        System.out.println("Hp: "+hp+"\nArmor: "+block+"\nStrength: "+str+"\n\nCrit chance: "+crit+"%\nDexterity: "+dex);
    }

}