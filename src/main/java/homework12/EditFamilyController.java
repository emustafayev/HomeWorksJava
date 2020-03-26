package homework12;

import homework12.exceptions.FamilyOverflowException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class EditFamilyController {
    Console console = new Console();
    private int MAXFAMILYSIZE = 6;
    private String MALE = "masculine";
    private String FEMALE = "feminine";


    public void familyController(FamilyService familyService){
        while (true){
            console.print(Menu.subMenu);
            boolean backToMain=false;
            console.print("Enter operation id");
            int userChoice = Parser.getUserChoice(console);
            switch (userChoice){
                case 1: giveABirthToBabyController(familyService);break;
                case 2: adoptAChildController(familyService);break;
                case 3: backToMain=true;break;
                default:console.print("Select ID correctly");break;
            }
            if(backToMain){
                break;
            }
        }
    }

    private void adoptAChildController(FamilyService familyService) {
        console.print("Enter index of family");
        int userChoice = Parser.getUserChoice(console);
        Family myFamily = familyService.getFamilyByIndex(userChoice);
        if(myFamily==null){
            console.print("There is no such family!");
        }else {
            if (myFamily.countFamily() < MAXFAMILYSIZE) {
                console.print("Enter the childr's name:");
                String childName = console.readLine();

                console.print("Enter the child's last name:");
                String childLastName = console.readLine();
                console.print("Enter the child's birthday ex 30/03/1999");
                String birthDay = console.readLine();
                console.print("Enter the child's gender!");
                String gender = console.readLine();


                String pattern = "dd/MM/yyyy";
                Date date = null;
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                try {
                    date = dateFormat.parse(birthDay);
                } catch (ParseException e) {
                    console.print("Incorrect date format");
                }
                console.print("Enter iq:");
                int iqF = Parser.getUserChoice(console);
                Human child = new Human(childName, childLastName, iqF, date.getTime(), gender);
                familyService.adoptChild(myFamily, child);

            } else throw new FamilyOverflowException("Family members cant be more than 6");
        }
    }



    private void giveABirthToBabyController(FamilyService familyService) {

        console.print("Enter index of family");
        int userChoice = Parser.getUserChoice(console);
        Family myFamily = familyService.getFamilyByIndex(userChoice);
        if(myFamily==null){
            console.print("There is no such family!");
        }else {
            if (myFamily.countFamily() < MAXFAMILYSIZE) {
                String gender = new Random().nextInt(2) == 1 ? MALE : FEMALE;
                String name;
                if (gender.equals(MALE)) {
                    console.print("Enter name for boy");
                    name = console.readLine();
                } else {
                    console.print("Enter name for girl");
                    name = console.readLine();
                }

                familyService.bornChild(myFamily, gender, name);
            } else throw new FamilyOverflowException("Family members cant be more than 6");
        }
    }

}
