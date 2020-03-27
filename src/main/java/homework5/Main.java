package homework5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Howard","Stark",1917);
        Human mother = new Human("Maria","Stark",1920);
        Human child1 = new Human("Tony","Stark",1970);
        Human child2 = new Human("????","Stark",1980);
        Human[] children = new Human[]{child1,child2};

        Pet pet1 = new Pet("dog","Miky");
        pet1.habits = new String[]{"Talking","Eating"};

        Family family  = new Family(father,mother);
        family.addChildren(children);
        family.setPet(pet1);
        family.deleteChild(0);

        System.out.println(family);
    }
}
