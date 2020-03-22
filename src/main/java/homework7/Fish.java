package homework7;

public class Fish extends Pet {

    public Species species;

    public Fish(Species spc,String nickname, int age, int trickLevel, String[] habits){
        super(nickname,age,trickLevel);
        this.species=spc;
    }

    @Override
    public void response() {
        System.out.println("I am fish!");
    }
}
