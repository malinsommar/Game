package Game;

public class Enemies {

    BasicSkills basicSkills;

    public void setActionStrategy(BasicSkills basicSkills){

        this.basicSkills = basicSkills;
    }
    public void preformAction(){

        basicSkills.attack();
        basicSkills.block();

    }
}
