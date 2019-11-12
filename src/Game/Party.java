package Game;

public abstract class Party implements BasicSkills{

    BasicSkills basicSkills;

    public void setActionStrategy(BasicSkills basicSkills){

        this.basicSkills = basicSkills;
    }
    public void preformAction(){

        basicSkills.attack();
        basicSkills.block();


    }
}
