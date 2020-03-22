package homework7;

import java.util.Random;

public final class  Woman extends Human implements HumanCreator {
    private Pet pet;

    public Woman(String name,Family family,int iq) {
        super(name,family,iq);
    }

    public Woman(String name,Family family, Pet pet,int iq) {
        this(name, family,iq);
        this.pet=pet;
    }

    @Override
    public void greetPet(){
        System.out.printf("Hello %s",pet);
    }

    public void makeUp(){
        System.out.println("Use Make Up!");
    }

    @Override
    public Human bornChild(Family family) {
        int childIQ = (family.getFather().getIQ()+family.getMother().getIQ())/2;
        return new Random().nextInt(2)==0?new Man(this.names[new Random().nextInt(names.length)],family,childIQ):
                new Woman(this.names[new Random().nextInt(names.length)],family,childIQ);
    }
}