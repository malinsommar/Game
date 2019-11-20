package Fights;

import Game.Healer;
import Game.Mage;
import Game.Ranger;
import Game.Warrior;

public class Turn extends ForestFight {

    int whosTurn = 0;

    public void getStats() {

        Warrior warrior = new Warrior();
        Mage mage = new Mage();
        Healer healer = new Healer();
        Ranger ranger = new Ranger();

        warriorCurrentHp = warrior.setHp();
        mageCurrentHp = mage.setHp();
        healerCurrentHp = healer.setHp();
        rangerCurrentHp = ranger.setHp();

        warriorDamage = warrior.setStr();
        mageDamage = mage.setStr();
        healerDamage = mage.setStr();
        rangerDamage = ranger.setStr();

    }

    public int plusTurn(){
        whosTurn++;

        return whosTurn;
    }



    public void wolfAttack() {
        int target = (int) (Math.random() * 4);
        int wolfDamage = (int) (Math.random() * 5) + 10;

        if (target == 0) {
            if (warriorCurrentHp < 1) {
                wolfAttack();
            }
            warriorCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked warrior, warrior lost " + wolfDamage + " hp.");
        }
        if (target == 1) {
            if (mageCurrentHp < 1) {
                wolfAttack();
            }
            mageCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked mage, warrior lost " + wolfDamage + " hp.");

        }
        if (target == 2) {
            if (rangerCurrentHp < 1) {
                wolfAttack();
            }
            rangerCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked ranger, warrior lost " + wolfDamage + " hp.");

        }
        if (target == 3) {
            if (healerCurrentHp < 1) {
                wolfAttack();
            }
            healerCurrentHp = -wolfDamage;
            System.out.println("Wolf attacked healer, warrior lost " + wolfDamage + " hp.");

        }
    }



    public void mobDeath(){

        if(enemies[0]<1){
            wolf1.setVisible(false);
        }
        if(enemies[1]<1){
            wolf2.setVisible(false);
        }
        if(enemies[2]<1){
            wolf3.setVisible(false);
        }
        if(enemies[3]<1){
            wolf4.setVisible(false);
        }
    }

    public int randomTarget(){
        int target = (int) (Math.random() * 4);

        if (target == 1 && enemies[0] < 1) {
            target = 2;
        }
        if (target == 2 && enemies[1] < 1) {
            target = 3;
        }
        if (target == 3 && enemies[2] < 1) {
            target = 4;
        }
        if (target == 4 && enemies[3] <1){
            target =1;
        }
        return target;
    }
}
