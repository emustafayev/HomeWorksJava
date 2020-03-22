package homework7;

public class DomesticCat extends Pet {

    public Species species;
    public DomesticCat(Species spc,String nickname, int age, int trickLevel){
        super(nickname,age,trickLevel);
        this.species=spc;
    }
    public void foul(){
        System.out.println("I need to cover it up!");
    }

    @Override
    public void response() {

    }
}
