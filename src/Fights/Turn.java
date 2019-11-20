package Fights;

import Game.Healer;
import Game.Mage;
import Game.Ranger;
import Game.Warrior;

public class Turn extends ForestFight {

    Warrior warrior = new Warrior();
    Mage mage = new Mage();
    Healer healer = new Healer();
    Ranger ranger = new Ranger();

    public void getStats() {

        warriorCurrentHp = warrior.setHp();
        mageCurrentHp = mage.setHp();
        healerCurrentHp = healer.setHp();
        rangerCurrentHp = ranger.setHp();

        warriorDamage = warrior.setStr();
        mageDamage = mage.setStr();
        healerDamage = mage.setStr();
        rangerDamage = ranger.setStr();

    }

    public int isFightOver() {
        if (enemies[0] < 1 && enemies[1] < 1 && enemies[2] < 1 && enemies[3] < 1) {
            //Victory screen
            int awnser = 1;
            return awnser;

        }
        if (warriorCurrentHp < 1 && mageCurrentHp < 1 && healerCurrentHp < 1 && rangerCurrentHp < 1) {
            //Game over
            int awnser = 2;
            return awnser;
        }
        //fight not over
        return 3;
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

    public void changeTurn(){

        if (whosTurn.getText().equals("Warrior's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -warriorDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Ranger's turn");
            playersHp.setText("Hp: "+rangerCurrentHp);
        }
        else if (whosTurn.getText().equals("Ranger's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -rangerDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Mage's turn");
            playersHp.setText("Hp: "+mageCurrentHp);
        }
        else if (whosTurn.getText().equals("Mage's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -mageDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Healers's turn");
            playersHp.setText("Hp: "+healerCurrentHp);
        }
        else if (whosTurn.getText().equals("Healers's turn")){
            attackButton.addActionListener(e -> enemies[randomTarget()] = -healerDamage);
            mobDeath();
            //isFightOver();
            whosTurn.setText("Enemies turn");
        }
        else if (whosTurn.getText().equals("Enemies turn")){
            attackButton.addActionListener(e -> warriorCurrentHp =-10);
            whosTurn.setText("Warrior'" + "s turn");
            playersHp.setText("Hp: "+warriorCurrentHp);

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
