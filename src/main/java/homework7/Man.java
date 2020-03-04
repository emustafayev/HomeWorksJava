package homework7;

public final class Man extends Human {
    public Man(String n, Species spc) {
        super(n,spc);
    }

    public void greetPet(){
        System.out.printf("Hello %s",pet);
    }

    public void repairCar(){
        System.out.println("Repairing!");
    }




}
