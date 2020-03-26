package homework13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FamilyController {
    public FamilyService familyService = new FamilyService();
    private Console console = new Console();
    private int MAXFAMILYSIZE = 6;
    private String MALE = "masculine";
    private String FEMALE = "feminine";
    private EditFamilyController editFamilyController = new EditFamilyController();
    public void run(){
        while(true){
            console.print(Menu.menuItem);
            int userChoice = Parser.getUserChoice(console);
            switch (userChoice){
                case 0:saveDataTOFIleController();break;
                case 1:downloadDataController();break;
                case 2:familyService.displayAllFamilies();break;
                case 3:getFamiliesBiggerThanController();break;
                case 4:getFamiliesLessThanController();break;
                case 5:console.print(countAccToMemberCountController());break;
                case 6:createNewFamilyController();break;
                case 7:deleteFamilyByIndexController();break;
                case 8:editFamilyController.familyController(familyService);break;
                case 9: removeChildren();break;
                case 10:terminateApp();break;
                default:console.print("Enter correct op ID");
            }
        }
    }

    private void saveDataTOFIleController() {
        boolean b = familyService.saveDataToFile();
        if (b){
            console.print("Data saved to db");
        }else console.print("error during saving data!");
    }

    private void downloadDataController() {
        boolean b = familyService.downloadData();
        if (b) {
            console.print("Data downloaded successfully!");
        } else {
            console.print("Error during downloading data!");
        }
    }

    private void terminateApp() {
        console.print("Bye!");
        System.exit(0);
    }

    private void removeChildren() {
        console.print("Enter age!");
        int userChoice = Parser.getUserChoice(console);
        if(familyService.deleteAllChildrenOlderThan(userChoice)){
            console.print("Deleted");
        }else console.print("Not deleted");
    }


    private void deleteFamilyByIndexController() {
        console.print("Enter the index!");
        int userChoice = Parser.getUserChoice(console);
        if(familyService.deleteFamilyByIndex(userChoice)){
            console.print("Deleted");
        }else console.print("Can not delete!");

    }

    private void createNewFamilyController() {
        console.print("Enter the mother's name:");
        String motherName = console.readLine();
        console.print("Enter the mother's last name:");
        String motherLastName = console.readLine();
        console.print("Enter the mother's birth year");
        int yearM = Parser.getUserChoice(console);
        console.print("Enter the mother's month of birth");
        int monthM = Parser.getUserChoice(console);
        console.print("Enter the mother's birthday");
        int dayM = Parser.getUserChoice(console);
        console.print("Enter iq:");
        int iqM = Parser.getUserChoice(console);

        String motherFullBirthDay = dayM+"/"+monthM+"/"+yearM;

        console.print("Enter the father's name:");
        String fatherName = console.readLine();
        console.print("Enter the father's last name:");
        String fatherLastName = console.readLine();
        console.print("Enter the father's birth year");
        int yearF = Parser.getUserChoice(console);
        console.print("Enter the father's month of birth");
        int monthF = Parser.getUserChoice(console);
        console.print("Enter the father's birthday");
        int dayF = Parser.getUserChoice(console);
        console.print("Enter iq:");
        int iqF = Parser.getUserChoice(console);

        String fatherFullBirthDay = dayF+"/"+monthF+"/"+yearF;
        console.print(fatherFullBirthDay);

        LocalDate localDate = Instant.ofEpochMilli(parseDate(fatherFullBirthDay)).atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate.getYear());

        Human mother = new Human(motherName,motherLastName,iqM,parseDate(motherFullBirthDay));
        Human father = new Human(fatherName,fatherLastName,iqF,parseDate(fatherFullBirthDay));

        familyService.createNewFamily(mother,father);

    }

    private long parseDate(String rawDate){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(rawDate);
        } catch (ParseException e) {
            System.out.println("Date time not in correct format!");
        }
        return date.getTime();
    }

    private String countAccToMemberCountController() {
        console.print("Enter Count of Memebers to calculate families numbers!");
        int userChoice = Parser.getUserChoice(console);
        return String.format("Number of Families: %d",familyService.numberOfFamiliesAbcToMemberCount(userChoice));
    }

    private void getFamiliesLessThanController() {
        console.print("Enter the count of family:");
        int userChoice = Parser.getUserChoice(console);
        familyService.getFamiliesLessThan(userChoice);
    }

    private void getFamiliesBiggerThanController() {
        console.print("Enter the count of family:");
        int userChoice = Parser.getUserChoice(console);
        familyService.getFamiliesBiggerThan(userChoice);
    }

    public void fillWithTestData() {

        Human father = new Human("Howard","Stark",45,1917);
        Human mother = new Human("Maria","Stark",34,1920);
        Human father2 = new Human("Father2","Faattherr2",55,1927);
        Human mother2 = new Human("Mother2","MOottherr2",34,1922);
        Human father3 = new Human("Father3","Faattherr3",75,1947);
        Human mother3 = new Human("Mother3","MOottherr3",34,1942);

        Human child1 = new Human("Tony","Stark",67,1970,"boy");
        Human child2 = new Human("IronMan","Stark",56,1980,"boy");
        Human child3 = new Human("????","Stark",87,1971,"boy");
        Human child4 = new Human("AdoptChild","Ivanov",78,1995,"girl");
        Pet pet1 = new Pet("Petty",3,23, Species.DOG);
        Pet pet2 = new Pet("Catty",4,34, Species.CAT);
        pet1.setHabits("eat");
        pet2.setHabits("sleepy");

        familyService.createNewFamily(mother,father);
        familyService.createNewFamily(mother2,father2);
        familyService.createNewFamily(mother3,father3);

        Family family1 = familyService.getFamilyByIndex(1);
        Family family2 = familyService.getFamilyByIndex(2);
        Family family3 = familyService.getFamilyByIndex(3);

        familyService.bornChild(family1,MALE,"Afgan");
        familyService.bornChild(family2,FEMALE,"Filankes");
        familyService.bornChild(family3,MALE,"Pesmankes");
        familyService.adoptChild(family3,child1);

        familyService.addPet(1,pet1);
        familyService.addPet(2,pet2);
        familyService.addPet(2,pet1);
        familyService.addPet(3,pet1);
        console.print("Addedd some test data");

    }
}
