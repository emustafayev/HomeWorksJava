package homework7;

public final class Man extends Human {
    private Pet pet;
    public Man(String name,Family family,int iq) {
        super(name,family,iq);
    }

    public Man(String name,Family family, Pet pet,int iq) {
        this(name,family,iq);
        this.pet = pet;
    }


    protected void greetPet(){
        System.out.println("Hello "+this.pet);
    }

    public void repairCar(){
        System.out.println("Repairing Car...!");
    }
}