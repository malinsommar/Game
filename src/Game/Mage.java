package Game;

public class Mage{

    String currentWeaponName = "Wodden wand";
    public int currentWeaponDamage = 5;

    String currentArmorName = "Cloth robe";
    public int currentArmorBlock = 0;

    public int hp = 100;
    public int block = 0;
    public int damage = 0;

    public int combinedBlock = block + currentArmorBlock;
    public int combinedDamage = damage + currentWeaponDamage;

    //All mage weapons
    public void mageRareWeapon(){
        currentWeaponName = "Ivory fire wand";
        currentWeaponDamage = 7;
    }
    public void mageEpicWeapon(){
        currentWeaponName= "Enchanted mana wand";
        currentWeaponDamage = 9;
    }
    public void mageLegendaryWeapon(){
        currentWeaponName = "Pyromaniac's tinderbox";
        currentWeaponDamage = 11;
    }
    //All mage armors
    public void mageRareArmor(){
        currentArmorName = "Mooncloth robe";
        currentArmorBlock = 2;
    }
    public void mageEpicArmor(){
        currentArmorName = "Enchanted robe";
        currentArmorBlock = 4;
    }
    public void mageLegendaryArmor(){
        currentArmorName = "Robe of the archmage";
        currentArmorBlock = 6;
    }
}