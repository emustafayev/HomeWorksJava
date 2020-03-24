package homework8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class FamilyTest {
    private Woman mother;
    private Human child;
    private Family family;
    @BeforeEach
    void setUp(){
        Dog dog = new Dog(Species.CAT,"Doggy",3,23);
        RoboCat roboCat = new RoboCat(Species.ROBOCAT,"Robo",3,34);
        mother = new Woman("Mommy",null,dog,40);
        Man father = new Man("Daddy",null,roboCat,60);
        family = new Family(mother,father);
        child = mother.bornChild(family);
        child.setName("ForTest");
    }


    @Test
    void bornChild() {
        assertEquals(child, mother.bornChild(family));// pass the test (50%/50%)
    }
}