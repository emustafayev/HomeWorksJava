package homework10;


import homework10.controller.FamilyController;
import homework10.entity.Human;
import homework10.entity.Pet;
import homework10.entity.Species;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws ParseException {
        FamilyController familyController = new FamilyController();
        String MALE = "masculine";
        String FEMALE = "feminine";
        Human father = new Human("Howard","Stark",45,1917);
        Human mother = new Human("Maria","Stark",34,1920);
        Human child1 = new Human("Tony","Stark",67,1970);
        Human child2 = new Human("IronMan","Stark",56,1980);
        Human child3 = new Human("????","Stark",87,1971);
        Human child4 = new Human("AdoptChild","Ivanov",78,1995);
        Human[] children = new Human[]{child1,child2};
        Pet pet1 = new Pet("Petty",3,23, Species.DOG);
        Pet pet2 = new Pet("Catty",4,34, Species.CAT);

        familyController.familyService.createNewFamily(mother,father);
        familyController.familyService.createNewFamily(mother,father);
        System.out.println(familyController.familyService.getFamilyByIndex(2));
        System.out.println(child1);

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


        String pattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = dateFormat.parse("30/03/1999");
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONTH)+1);
    }
}
