package homework11;

import homework9.Family;
import homework9.FamilyController;
import homework9.Human;
import homework9.Pet;
import homework9.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    private homework9.FamilyController familyController = new FamilyController();
    private String MALE = "masculine";
    private String FEMALE = "feminine";
    private homework9.Human father;
    private homework9.Human mother;
    private homework9.Human child1;
    private homework9.Human child2;
    private homework9.Human child3;
    private homework9.Human child4;
    private homework9.Pet pet1;
    private homework9.Pet pet2;
    private homework9.Family testFamily;
    private List<homework9.Family> families = new ArrayList<>();
    private homework9.Human bornedChild;

    @BeforeEach
    void setUp() {
        father = new homework9.Human("Howard","Stark",1917,45);
        mother = new homework9.Human("Maria","Stark",1920,34);
        child1 = new homework9.Human("Tony","Stark",1970,67);
        child2 = new homework9.Human("IronMan","Stark",1999,56);
        child3 = new homework9.Human("????","Stark",1971,87);
        child4 = new homework9.Human("AdoptChild","Ivanov",1995,78);
        pet1 = new homework9.Pet("Petty",3,23, homework9.Species.DOG);
        pet2 = new Pet("Catty",4,34, Species.CAT);
        bornedChild = new homework9.Human("John","Stark",2020,39);

        familyController.familyService.createNewFamily(mother,father);
    }


    @Test
    void getFamilyByIndex() {
        assertEquals(testFamily, familyController.familyService.getFamilyByIndex(1));
    }

    @Test
    void getFamiliesBiggerThanTest() {
        //assertEquals(families,familyController.familyService.getFamiliesBiggerThan(1));//TODO testing void func
    }

    @Test
    void getFamiliesLessThan() {

    }

    @Test
    void createNewFamily() {
        homework9.Human mother = new homework9.Human("Test1","Testttt1",1987,45);
        homework9.Human father = new homework9.Human("Test2","Testttt2",1977,65);
        homework9.Family testFamily2 = new homework9.Family(3,mother,father);
        familyController.familyService.createNewFamily(mother,father);
        assertEquals(testFamily2,familyController.familyService.getFamilyByIndex(3));
    }

    @Test
    void bornChild() {
        homework9.Family family = familyController.familyService.getFamilyByIndex(1);
        assertEquals(bornedChild, familyController.familyService.bornChild(family, MALE).getChildren().get(0));

    }

    @Test
    void adoptChild() {
        homework9.Family family = familyController.familyService.getFamilyByIndex(1);
        assertEquals(child3, familyController.familyService.adoptChild(family, child3).getChildren().get(0));
    }

    @Test
    void deleteAllChildrenOlderThan() {
        homework9.Family family = familyController.familyService.getFamilyByIndex(1);
        familyController.familyService.adoptChild(family,child1);
        familyController.familyService.adoptChild(family,child2);
        familyController.familyService.deleteAllChildrenOlderThan(30);
        List<Human> testList = new ArrayList<>();
        testList.add(child2);
        assertEquals(testList,family.getChildren());

    }

    @Test
    void getPets() {
        homework9.Family family = familyController.familyService.getFamilyByIndex(1);
        assertEquals(family.getPet(),familyController.familyService.getPets(1));
    }

    @Test
    void addPet() {
        Family family = familyController.familyService.getFamilyByIndex(1);
        familyController.familyService.addPet(1,pet1);
        familyController.familyService.addPet(1,pet2);
        assertEquals(family.getPet(),familyController.familyService.getPets(1));
    }//https://docs.google.com/forms/d/e/1FAIpQLSdKzBKypbZI3YQ2q3ZcbXw0tbu3kkBmX_Wt3-p4RtLngMs_BA/viewform
}

