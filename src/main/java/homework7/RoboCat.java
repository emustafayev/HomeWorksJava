package homework7;

public class RoboCat extends Pet {

    public Species species;
    public RoboCat(Species spc,String nickname, int age, int trickLevel){
        super(nickname,age,trickLevel);
        this.species=spc;

    }
    @Override
    public void response() {
        System.out.println("I am robot cat!");
    }
}
