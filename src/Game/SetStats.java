package Game;

public class SetStats {

    private Party war;
    private Party mag;
    private Party ran;
    private Party hea;

    public void setStat(){

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

    }
}