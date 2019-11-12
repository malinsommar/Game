package Game;

public abstract class Party{

    BasicSkills basicSkills;

    public abstract void greet();

    public void setActionStrategy(BasicSkills basicSkills){

        this.basicSkills = basicSkills;
    }
    public void preformAction(){

        basicSkills.attack();
        basicSkills.block();

    }
}