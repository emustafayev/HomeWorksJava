package abstractClassTest;

public class Cat extends Animal implements Climb {
    public Cat(String name, int lifeExpentency) {
        super(name, lifeExpentency);
    }

    @Override
    public void remember() {
        System.out.println(this.getClass().getSimpleName() + " can remember for 16 hours");
    }

    @Override
    public void protectOwner() {
        System.out.println(this.getClass().getSimpleName()+ " won't protect owner");
    }

    @Override
    public void climb() {
        System.out.println(this.getClass().getSimpleName()+ " can climb");
    }
}
