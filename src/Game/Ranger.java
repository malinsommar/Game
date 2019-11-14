package Game;

import Armor.RangerStartArmor;
import Weapons.RangerStartWeapon;

import java.util.ArrayList;

public class Ranger {

    ArrayList rangerWeapon = new ArrayList();
    ArrayList rangerArmor = new ArrayList();

    public int hp=70;
    public int block=0;
    public int str=0;
    public int crit=15;
    public int dex=5;

    public void setStartEquipment() {
        rangerWeapon.add(new RangerStartWeapon());
        rangerArmor.add(new RangerStartArmor());
    }
    public void printOutStats(){
        System.out.println("Hp: "+hp+"\nArmor: "+block+"\nStrength: "+str+"\n\nCrit chance: "+crit+"%\nDexterity: "+dex);
    }
}