package homework11;


import homework11.entity.Family;
import homework11.entity.Human;
import homework11.entity.Pet;
import homework11.entity.Species;
import homework11.service.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FamilyServiceTest {
    private FamilyService familyService = new FamilyService();
    private String MALE = "masculine";
    private String FEMALE = "feminine";
    private Human father;
    private Human mother;
    private Human child1;
    private Human child2;
    private Human child3;
    private Human child4;
    private Pet pet1;
    private Pet pet2;
    private Family testFamily;
    private List<Family> families = new ArrayList<>();
    private Human bornedChild;

    @BeforeEach
    void setUp() {
        father = new Human("Howard","Stark",1917,45);
        mother = new Human("Maria","Stark",1920,34);
        child1 = new Human("Tony","Stark",1970,67);
        child2 = new Human("IronMan","Stark",1999,56);
        child3 = new Human("????","Stark",1971,87);
        child4 = new Human("AdoptChild","Ivanov",1995,78);
        pet1 = new Pet("Petty",3,23, Species.DOG);
        pet2 = new Pet("Catty",4,34,Species.CAT);
        bornedChild = new Human("John","Stark",2020,39);
        testFamily = new Family(1,mother,father);

        familyService.createNewFamilyForTest(mother,father);
    }

    @Test
    void getFamilyByIndex() {
        assertEquals(testFamily, familyService.getFamilyByIndex(1));
    }

    @Test
    void getFamiliesLessThan() {

    }

    @Test
    void createNewFamily() {
        Human mother = new Human("Test1","Testttt1",1987,45);
        Human father = new Human("Test2","Testttt2",1977,65);
        Family testFamily2 = new Family(3,mother,father);
        familyService.createNewFamily(mother,father);
        assertEquals(testFamily,familyService.getFamilyByIndex(1));
    }


    @Test
    void bornChild() {
        Family family = familyService.getFamilyByIndex(1);
        assertEquals(bornedChild, familyService.bornChild(family, MALE).getChildren().get(0));
    }

    @Test
    void adoptChild() {
        Family family = familyService.getFamilyByIndex(1);
        assertEquals(child3, familyService.adoptChild(family, child3).getChildren().get(0));
    }

    @Test
    void deleteAllChildrenOlderThan() {
        Family family = familyService.getFamilyByIndex(1);
        familyService.adoptChild(family,child1);
        familyService.adoptChild(family,child2);
        familyService.deleteAllChildrenOlderThan(30);
        List<Human> testList = new ArrayList<>();
        testList.add(child2);
        assertEquals(testList,family.getChildren());
    }

    @Test
    void getPets() {
        Family family = familyService.getFamilyByIndex(1);
        assertEquals(family.getPet(),familyService.getPets(1));
    }

    @Test
    void addPet() {
        Family family = familyService.getFamilyByIndex(1);
        familyService.addPet(1,pet1);
        familyService.addPet(1,pet2);
        assertEquals(family.getPet(),familyService.getPets(1));
    }//https://docs.google.com/forms/d/e/1FAIpQLSdKzBKypbZI3YQ2q3ZcbXw0tbu3kkBmX_Wt3-p4RtLngMs_BA/viewform
}

