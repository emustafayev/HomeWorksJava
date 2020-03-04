package homework7;

public class RoboCat extends Pet {

    public Species species;
    public RoboCat(Species spc,String nickname, int age, int trickLevel, String[] habits){
        super(nickname,age,trickLevel,habits);
        this.species=spc;

    }
    @Override
    public void response() {
        System.out.println("I am robot cat!");
    }
}
