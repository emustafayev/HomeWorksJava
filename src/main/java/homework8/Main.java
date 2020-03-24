package homework8;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog(Species.CAT,"Doggy",3,23);
        RoboCat roboCat = new RoboCat(Species.ROBOCAT,"Robo",3,34);
        roboCat.eat();
        dog.foul();
        Woman mother = new Woman("Mommy",null,dog,40);
        Man father = new Man("Daddy",null,roboCat,60);
        Family family = new Family(mother,father);
        Human child = mother.bornChild(family);


        System.out.println(child.family.getFather().name);
        System.out.println(child.getIQ());
        Set<Pet> set= new HashSet<>();
    }
}
