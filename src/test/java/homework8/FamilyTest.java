package homework8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class FamilyTest {

    private List<Human> expectedChildren = new ArrayList<>();
    private Family family;
    private Human child;
    private Human child2;
    private Human child3;

    @BeforeEach
    void __init__(){
        Human father =new Human("Dada","SurnameDADA",1978,34);
        Human mother = new Human("Mom","MomSurname",1984,54);
        child = new Human("Child1","Surname1",1999,65);
        child2 = new Human("Child2","Surname2",1992,76);
        child3 = new Human("Child3","Surname3",1991,78);
        Pet dog = new Pet("Kotty",12,52,Species.DOG);
        family = new Family(mother,father);
        family.addPet(dog);
        family.addChild(child);
        family.addChild(child2);
        expectedChildren.add(child);
        expectedChildren.add(child2);

    }

    @Test
    void addChildrenTest() {
        family.addChildren(expectedChildren);
        assertEquals(expectedChildren,family.getChildren());
    }

    @Test
    void testdeleteChild() {
        expectedChildren.remove(child);
        family.deleteChild(child);
        assertEquals(expectedChildren,family.getChildren());
    }

    @Test
    void addChild() {
        expectedChildren.add(child3);
        family.addChild(child3);
        assertEquals(expectedChildren,family.getChildren());
    }

    @Test
    void testToString() {
        family.addChild(child3);
        assertEquals("Family{father=Dada SurnameDADA,mother=Mom MomSurname,children=[Human{name=Child1, surname=Surname1, year=1999, iq=65, Human{name=Child2, surname=Surname2, year=1992, iq=76, Human{name=Child3, surname=Surname3, year=1991, iq=78],pet=[pet={nickname=Kotty, age=12,tricklevel=52],}",family.toString());
    }
}