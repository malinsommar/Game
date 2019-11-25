package Game;

import javax.swing.*;

public class Inventory {

    public ImageIcon minorHealthGif = new ImageIcon("minorHealth.gif");
    public ImageIcon lesserHealthGif = new ImageIcon("lesserHealth.gif");
    public ImageIcon majorHealthGif = new ImageIcon("majorHealth.gif");

    public ImageIcon minorBlockGif = new ImageIcon("minorBlock.gif");
    public ImageIcon lesserBlockGif = new ImageIcon("lesserBlock.gif");
    public ImageIcon majorBlockGif = new ImageIcon("majorBlock.gif");

    public ImageIcon minorEnergyGif = new ImageIcon("minorEnergy.gif");
    public ImageIcon lesserEnergyGif = new ImageIcon("lesserEnergy.gif");
    public ImageIcon majorEnergyGif = new ImageIcon("majorEnergy.gif");

    public ImageIcon minorStrGif = new ImageIcon("minorStrength.gif");
    public ImageIcon lesserStrGif = new ImageIcon("lesserStrength.gif");
    public ImageIcon majorStrGif = new ImageIcon("majorStrength.gif");

    int minorHealingPotion = 10, lesserHealingPotion = 30, majorHealingPotion = 60;
    int ownedMinorHealingPotion = 1, ownedLesserHealingPotion = 0, ownedMajorHealingPotion = 0;

    int minorBlockPotion = 5, lesserBlockPotion = 20, majorBlockPotion = 50;
    int ownedMinorBlockPotion = 1, ownedLesserBlockPotion = 0, ownedMajorBlockPotion = 0;

    int minorEnergyPotion = 3, lesserEnergyPotion = 5, majorEnergyPotion = 10;
    int ownedMinorEnergyPotion = 1, ownedLesserEnergyPotion = 0, ownedMajorEnergyPotion = 0;

    int minorStrengthPotion = 5, lesserStrengthPotion = 10, majorStrengthPotion = 20;
    int ownedMinorStrengthPotion = 5, ownedLesserStrengthPotion = 10, ownedMajorStrengthPotion = 20;


    public void addPotion(int potion) {

        switch (potion) {
            //Healing potions
            case 1:
                ownedMinorHealingPotion++;

            case 2:
                ownedLesserHealingPotion++;

            case 3:
                ownedMajorHealingPotion++;

                //Block potions
            case 4:
                ownedMinorBlockPotion++;

            case 5:
                ownedLesserBlockPotion++;

            case 6:
                ownedMajorBlockPotion++;

                //Energy potions
            case 7:
                ownedMinorEnergyPotion++;

            case 8:
                ownedLesserEnergyPotion++;

            case 9:
                ownedMajorEnergyPotion++;

                //Strength potions
            case 10:
                ownedMinorStrengthPotion++;

            case 11:
                ownedLesserStrengthPotion++;

            case 12:
                ownedMajorStrengthPotion++;
        }
    }

    public void usePotion(int use) {
        switch (use) {
            //Healing potions
            case 1:
                ownedMinorHealingPotion--;

            case 2:
                ownedLesserHealingPotion--;

            case 3:
                ownedMajorHealingPotion--;

                //Block potions
            case 4:
                ownedMinorBlockPotion--;

            case 5:
                ownedLesserBlockPotion--;

            case 6:
                ownedMajorBlockPotion--;

                //Energy potions
            case 7:
                ownedMinorEnergyPotion--;

            case 8:
                ownedLesserEnergyPotion--;

            case 9:
                ownedMajorEnergyPotion--;

                //Strength potions
            case 10:
                ownedMinorStrengthPotion--;

            case 11:
                ownedLesserStrengthPotion--;

            case 12:
                ownedMajorStrengthPotion--;
        }
    }
}