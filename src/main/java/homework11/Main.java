package homework11;


import homework11.controller.FamilyController;
import homework11.entity.Human;
import homework11.entity.Pet;
import homework11.entity.Species;

public class Main {

    public static void main(String[] args) {
        FamilyController familyController = new FamilyController();
        String MALE = "masculine";
        String FEMALE = "feminine";
        Human father = new Human("Howard","Stark",1917,45);
        Human mother = new Human("Maria","Stark",1920,34);
        Human child1 = new Human("Tony","Stark",1970,67);
        Human child2 = new Human("IronMan","Stark",1980,56);
        Human child3 = new Human("????","Stark",1971,87);
        Human child4 = new Human("AdoptChild","Ivanov",1995,78);
        Human[] children = new Human[]{child1,child2};
        Pet pet1 = new Pet("Petty",3,23, Species.DOG);
        Pet pet2 = new Pet("Catty",4,34, Species.CAT);

        familyController.familyService.createNewFamily(mother,father);
        familyController.familyService.createNewFamily(mother,father);
        System.out.println(familyController.familyService.getFamilyByIndex(2));

//        familyController.familyService.addPet(1,pet1);
//        Family myHappyFamily = familyController.familyService.getFamilyByIndex(1);
//        familyController.familyService.adoptChild(myHappyFamily,child2);
//        familyController.familyService.adoptChild(myHappyFamily,child3);
//        Family family = familyController.familyService.bornChild(myHappyFamily, "feminine");
//        familyController.familyService.getFamiliesBiggerThan(1);
//        Family family1 = familyController.familyService.deleteAllChildrenOlderThan(30);
//        System.out.println(family1);
//        System.out.println(familyController.familyService.getPets(1).toString());
        familyController.familyService.displayAllFamilies();

        String st = "hello";
        System.out.printf("%15s",st);

    }
}
