package homework9.service;

import homework9.ui.Console;
import homework9.entity.Human;
import homework9.entity.Pet;
import homework9.dao.CollectionFamilyDAO;
import homework9.entity.Family;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private CollectionFamilyDAO db = new CollectionFamilyDAO();
    private Console console = new Console();
    private String[] girlNames = new String[]{"Angelina","Emilia","Sarah","Chloe"};
    private String[] boyNames = new String[]{"John","Tony","Steve","Alex"};

    public void displayAllFamilies(){
        db.getAllFamilies().forEach(family ->
                console.print(family.toString()));
    }

    public Family getFamilyByIndex(int index){
        return db.getFamilyByIndex(index);
    }

    public void getFamiliesBiggerThan(int count){
        db.getData()
                .stream().filter(family ->
                family.countFamily()>count)
                .collect(Collectors.toList())
                .forEach(f ->
                        console.print(f.toString()));
    }

    public void getFamiliesLessThan(int count){
        for(Family family:db.getData().stream().filter(family ->
                family.countFamily()<count)
                .collect(Collectors.toList())){
            console.print(family.toString());
        }
    }

    public void createNewFamilyForTest(Human mother, Human father){
        db.saveFamily(new Family(1,mother,father));
    }
    public void createNewFamily(Human mother, Human father){
        db.saveFamily(new Family(mother,father));
    }

    public Family bornChild(Family family, String gender){
        family.getChildren().add(new Human(
                gender.equals("masculine")?boyNames[new Random().nextInt(boyNames.length)]: girlNames[new Random().nextInt(girlNames.length)],
                family.getFather().surname,
                LocalDate.now().getYear(),
                (family.getFather().IQ_level+family.getMother().IQ_level)/2));
        return family;
    }

    public Family adoptChild(Family family, Human child){
        family.getChildren().add(child);
        return family;
    }


    public Family deleteAllChildrenOlderThan(int childAge){
        int dateOfBorn = LocalDate.now().getYear()-childAge;
        return db.getData().stream()
                .peek(family -> family.setChildren(family.getChildren()
                .stream()
                .filter(child ->
                        child.date_of_birth > dateOfBorn)
                .collect(Collectors.toList()))).collect(Collectors.toList()).get(0);
    }

    public Set<Pet> getPets(int familyIndex){
        return db.getFamilyByIndex(familyIndex).getPet();
    }

    public void addPet(int index, Pet pet){
        db.getFamilyByIndex(index).getPet().add(pet);
    }

}
