package Game;

public class SetStats {

    private Party war;
    private Party mag;
    private Party ran;
    private Party hea;

    public void setStat(){

        war = new Warrior();
        mag = new Mage();
        ran = new Ranger();
        hea = new Healer();

        war.setActionStrategy(new BasicAttackBlock());
        mag.setActionStrategy(new BasicAttackBlock());
        ran.setActionStrategy(new BasicAttackBlock());
        hea.setActionStrategy(new BasicAttackBlock());

        hea.preformAction();


    }
}