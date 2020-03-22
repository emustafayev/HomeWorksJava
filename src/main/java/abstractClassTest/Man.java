package abstractClassTest;

public class Man implements Learn,Climb,Apply,Think {
    String name;
    int age;
    public Man(String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public void apply() {
        System.out.println("I can apply:"+this.getClass().getSimpleName());
    }

    @Override
    public void climb() {
        System.out.println("I can climb:"+this.getClass().getSimpleName());
    }

    @Override
    public void learn() {
        System.out.println("I can learn:"+this.getClass().getSimpleName());
    }

    @Override
    public void think() {
        System.out.println("I can think:"+this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Man :"+name+":Age:"+age;
    }
}
