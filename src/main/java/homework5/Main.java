package homework5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("Howard","Stark",1917);
        Human mother = new Human("Maria","Stark",1920);
        Human child1 = new Human("Tony","Stark",1970);
        Human[] children = new Human[]{child1};
        Pet pet1 = new Pet("dog","Miky");
        pet1.habits = new String[]{"Talking","Eating"};

        Family family  = new Family(father,mother);
        family.setFather(father);
        family.setMother(mother);
        family.addChildren(children);
        Human[] children2 = Arrays.copyOf(children,2);
        Human child2 = new Human("????","Stark",1980);
        children2[children2.length-1] = child2;
        family.setChildren(children2);
        family.setPet(pet1);

        System.out.println(family.deleteChild(child2));
        System.out.println(family.getPet());
    }
}
