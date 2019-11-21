package Game;

import Armor.HealerStartArmor;
import Weapons.HealerStartWeapon;

import java.util.ArrayList;

public class main {

    public static void main(String[] args){
        new Hub();
    }

    public static class Healer {

        ArrayList healerWeapon = new ArrayList();
        ArrayList healerArmor = new ArrayList();

        public int hp=100;
        public int block=0;
        public int str=0;
        public int crit=5;
        public int dex=0;

        public void setStartEquipment() {
            healerWeapon.add(new HealerStartWeapon());
            healerArmor.add(new HealerStartArmor());
        }
        public void printOutStats(){
            System.out.println("Hp: "+hp+"\nArmor: "+block+"\nStrength: "+str+"\n\nCrit chance: "+crit+"%\nDexterity: "+dex);
        }
    }
}