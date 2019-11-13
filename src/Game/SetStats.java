package Game;

public class SetStats {

    Warrior warrior = new Warrior();
    Mage mage = new Mage();
    Healer healer = new Healer();
    Ranger ranger = new Ranger();

 /*   private Party war;
    private Party mag;
    private Party ran;
    private Party hea;

    private Enemies wolf;
    private Enemies wolfBoss;*/

    public void setStat(){

        warrior.setStartEquipment();
        mage.setStartEquipment();
        healer.setStartEquipment();
        ranger.setStartEquipment();


        /*
        //Create party
        war = new Warrior();
        mag = new Mage();
        ran = new Ranger();
        hea = new Healer();


        //Set party abilities.
        war.setActionStrategy(new BasicAttackBlock());
        mag.setActionStrategy(new BasicAttackBlock());
        ran.setActionStrategy(new BasicAttackBlock());
        hea.setActionStrategy(new BasicAttackBlock());

        // Så här gör vi för att preforma actions: war.preformAction();
*/
    }
}