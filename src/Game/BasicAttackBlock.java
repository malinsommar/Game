package Game;

public class BasicAttackBlock implements BasicSkills {

    @Override
    public void attack() {
        System.out.println("Attack!");
    }

    @Override
    public void block() {
        System.out.println("Block up.");
    }
}
