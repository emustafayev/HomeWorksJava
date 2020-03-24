package homework6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HappyFamilyTest {

    private HappyFamily family;
    private Human father;
    private Human mother;
    private Human[] children = new Human[5];
    private Human[] newChildrenArray;
    private Human[] arrayForDeletedChild = new Human[2];
    private Human child3;
    @BeforeEach
    void setUp() {
        father =new Human("Dada","SurnameDADA",1978);
        mother = new Human("Mom","MomSurname",1984);
        Pet pet1 = new Pet(Species.CAT,"Kotty");
        family = new HappyFamily(mother,father,pet1);
        Human child1 = new Human("NameChild1","Surnamechild1",1999);
        Human child2 = new Human("NameChild2","Surnamechild2",1996);
        child3 = new Human("NameChild3","SurnameChild3",2001);

        Human child4 = new Human("NameChild4","SurnameChild4",2001);
        children = new Human[]{ child1,child2,child3} ;
        family.addChildren(children);

        arrayForDeletedChild[0] = child1;
        arrayForDeletedChild[1] = child2;

        newChildrenArray = Arrays.copyOf(children,children.length+1);
        newChildrenArray[newChildrenArray.length-1] = child4;

    }

    @Test
    void countFamilyTest() {
        assertEquals(5,family.countFamily());
    }

    @Test
    void getMotherTest() {
        assertEquals(mother,family.getMother());
    }

    @Test
    void getFather() {
        assertEquals(father,family.getFather());
    }

    @Test
    void getChildrenTest() {
        assertEquals(children, family.getChildren());
    }

    @Test
    void addChildren() {
        assertEquals(newChildrenArray,family.addChildren(newChildrenArray));
    }

    @Test
    void deleteChildTest() {
        assertTrue(family.deleteChild(child3));
    }

    @Test
    void deleteChildWithIndexTest(){
        assertTrue(family.deleteChild(1));
    }

    @Test
    void addChildTest() {
        assertTrue(family.addChild(child3));
    }

    @Test
    void testToString() {
        assertEquals("Family{father=Dada SurnameDADA,mother=Mom MomSurname,children=[Human{name=NameChild1, surname=Surnamechild1, year=1999, Human{name=NameChild2, surname=Surnamechild2, year=1996, Human{name=NameChild3, surname=SurnameChild3, year=2001],pet=Kotty,}",family.toString());
    }
}