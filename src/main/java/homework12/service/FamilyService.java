package homework12.service;

import homework12.entity.Pet;
import homework12.dao.CollectionFamilyDAO;
import homework12.entity.Family;
import homework12.entity.Human;
import homework12.ui.Console;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private CollectionFamilyDAO db = new CollectionFamilyDAO();
    private Console console = new Console();
    private String[] girlNames = new String[]{"Angelina","Emilia","Sarah","Chloe"};
    private String[] boyNames = new String[]{"John","Tony","Steve","Alex"};

    public void displayAllFamilies(){
        db.getAllFamilies().forEach(family ->
                console.print(family.prettyFormat()));
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
                        console.print(f.prettyFormat()));
    }

    public void getFamiliesLessThan(int count){
        for(Family family:db.getData().stream().filter(family ->
                family.countFamily()<=count)
                .collect(Collectors.toList())){
            console.print(family.prettyFormat());
        }
    }

    public void createNewFamily(Human mother, Human father){
        db.saveFamily(new Family(mother,father));
    }

    public void createNewFamilyForTest(Human mother, Human father){
        db.saveFamily(new Family(1,mother,father));
    }


    /*
    * Human can not predict borned child is boy or girl
    * that is why i randomly choose sex of child and
    * according to that i ask user to enter boy or girl name*/

    public Family bornChild(Family family, String gender,String name)  {
        family.getChildren().add(new Human(
                name,
                family.getFather().surname,
                (family.getFather().IQ_level+family.getMother().IQ_level)/2,LocalDate.now().getYear(),gender));
        return family;
    }

    public boolean deleteFamilyByIndex(int index){
        return db.deleteFamily(index);
    }

    public Family adoptChild(Family family, Human child){
        family.getChildren().add(child);
        return family;
    }


    private boolean removeIf(int dateOfBorn){
        return !db.getData().stream()
                .peek(family -> family.setChildren(family.getChildren()
                        .stream()
                        .filter(child ->
                                child.getYear() > dateOfBorn)
                        .collect(Collectors.toList()))).collect(Collectors.toList()).isEmpty();
    }

    public boolean deleteAllChildrenOlderThan(int childAge){
        int dateOfBorn = LocalDate.now().getYear()-childAge;
        return removeIf(dateOfBorn);
    }

    public int numberOfFamiliesAccToMemeberCount(int countOfMembers){
        return (int) this.db.getData().stream().filter(family -> family.countFamily() == countOfMembers).count();
    }

    public Set<Pet> getPets(int familyIndex){
        return db.getFamilyByIndex(familyIndex).getPets();
    }

    public void addPet(int index, Pet pet){
        db.getFamilyByIndex(index).getPets().add(pet);
    }
}
