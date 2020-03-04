package homework7;

public class DomesticCat extends Pet {

    public Species species;
    public DomesticCat(Species spc,String nickname, int age, int trickLevel, String[] habits){
        super(nickname,age,trickLevel,habits);
        this.species=spc;
    }
    public void foul(){
        System.out.println("I need to cover it up!");
    }

    @Override
    public void response() {

    }
}
