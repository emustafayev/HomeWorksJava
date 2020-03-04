package homework4;

public class HumanApp {
    public static void main(String[] args) {

        String[] pet1Habits = new String[]{"sleepy", "eat much","cute"};
        Pet pet1 = new Pet("petSpecie","Petty",3,40,pet1Habits);

        Human mother = new Human("MyMom","MyMomSurname",1981);
        Human father = new Human("MyFather","MyFatherSurname",1975);
        Human child = new Human("Ali", "Valiyev",1999,father,mother,pet1,86);

        System.out.println(child.toString());
        System.out.println(child.pet.toString());
        System.out.println(child.father.name);
        child.pet.eat();
        System.out.println();
        child.pet.response();
        System.out.println();
        child.greetPet();
        System.out.println();
        child.describePet();
    }
}