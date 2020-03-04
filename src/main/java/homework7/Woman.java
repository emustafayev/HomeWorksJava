package homework7;

public final class  Woman extends Human {

    public Woman(String n, Species spc) {
        super(n,spc);
    }

    public void greetPet(){
        System.out.printf("Hello %s",pet);
    }

    public void makeUp(){
        System.out.println("Use Make Up!");
    }
}
