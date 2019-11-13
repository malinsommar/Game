package Game;

import Armor.HealerStartArmor;
import Weapons.HealerStartWeapon;

import java.util.ArrayList;

public class Healer extends Party {

    ArrayList healerWeapon = new ArrayList();
    ArrayList healerArmor = new ArrayList();

    public int hp=100;
    public int block=0;
    public int str=0;
    public int inte=5;
    public int crit=5;
    public int dex=0;

    public void setStartEquipment() {
        healerWeapon.add(new HealerStartWeapon());
        healerArmor.add(new HealerStartArmor());
    }
    public void printOutStats(){
        System.out.println("Hp: "+hp+"\nArmor: "+block+"\nStrength: "+str+"\nIntelligence: "+inte+"\nCrit chance: "+crit+"%\nDexterity: "+dex);
    }
}