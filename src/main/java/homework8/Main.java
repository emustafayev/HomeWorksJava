package homework8;


import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Human father =new Human("Dada","SurnameDADA",1978,34);
        Human mother = new Human("Mom","MomSurname",1984,54);
        Human child = new Human("Child1","Surname1",1999,65);
        Human child2 = new Human("Child2","Surname2",1992,76);
        Human child3 = new Human("Child3","Surname3",1991,78);
        Pet dog = new Pet("Kotty",12,52,Species.DOG);
        Family family = new Family(mother,father);
        family.addPet(dog);
        System.out.println(family.getPet().toString());
        family.addChild(child);
        family.addChild(child2);
        family.addChild(child3);
        System.out.println(family);

    }

}
