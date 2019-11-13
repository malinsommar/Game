package Game;

import Armor.WarriorStartArmor;
import Weapons.WarriorStartWeapon;
import java.util.ArrayList;

public class Warrior extends Party{

    ArrayList warriorWeapon = new ArrayList();
    ArrayList warriorArmor = new ArrayList();

    public int hp=150;
    public int block=0;
    public int str=5;
    public int inte=0;
    public int crit=5;
    public int dex=0;

    public void setStartEquipment() {
        warriorWeapon.add(new WarriorStartWeapon());
        warriorArmor.add(new WarriorStartArmor());
    }
    public void printOutStats(){
        System.out.println("Hp: "+hp+"\nArmor: "+block+"\nStrength: "+str+"\nIntelligence: "+inte+"\nCrit chance: "+crit+"%\nDexterity: "+dex);
    }
}