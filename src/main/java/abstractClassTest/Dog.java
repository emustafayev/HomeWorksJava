package abstractClassTest;

public class Dog extends Animal implements Learn {
    public Dog(String name, int lifeExpentency) {
        super(name, lifeExpentency);
    }

    @Override
    public void remember() {
        System.out.println(this.getClass().getSimpleName()+" can remember for 5 minutes");
    }

    @Override
    public void protectOwner() {
        System.out.println(this.getClass().getSimpleName()+ " will protect owner");
    }

    @Override
    public void learn() {
        System.out.println(this.getClass().getSimpleName()+ " can learn:");
    }
}
