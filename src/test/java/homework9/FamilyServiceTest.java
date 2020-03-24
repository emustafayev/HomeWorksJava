package homework9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    private FamilyController familyController = new FamilyController();
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

    @BeforeEach
    void setUp() {
        father = new Human("Howard","Stark",1917,45);
        mother = new Human("Maria","Stark",1920,34);
        child1 = new Human("Tony","Stark",1970,67);
        child2 = new Human("IronMan","Stark",1980,56);
        child3 = new Human("????","Stark",1971,87);
        child4 = new Human("AdoptChild","Ivanov",1995,78);
        pet1 = new Pet("Petty",3,23,Species.DOG);
        pet2 = new Pet("Catty",4,34,Species.CAT);

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
        Human mother = new Human("Test1","Testttt1",1987,45);
        Human father = new Human("Test2","Testttt2",1977,65);
        Family testFamily2 = new Family(3,mother,father);
        familyController.familyService.createNewFamily(mother,father);
        assertEquals(testFamily2,familyController.familyService.getFamilyByIndex(3));
    }

    @Test
    void bornChild() {
    }

    @Test
    void adoptChild() {
    }

    @Test
    void deleteAllChildrenOlderThan() {
    }

    @Test
    void getPets() {
    }

    @Test
    void addPet() {
    }
}