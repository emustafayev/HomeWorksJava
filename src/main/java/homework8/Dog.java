package homework8;

public class Dog extends Pet implements Foul {

    public Species species;
    public Dog(Species spc, String nickname, int age, int trickLevel){
        super(nickname,age,trickLevel);
        this.species=spc;
    }

    @Override
    public void foul(){
        System.out.println("I need to cover it up!");
    }

    @Override
    public void response() {
        System.out.println("I am DOG!");
    }
}
