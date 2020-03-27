package homework8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        pets = new HashSet<>();
    }

    public void addPets(Pet pet) {
        this.pets.add(pet);
    }

    public Human getMother() {
        return mother;
    }

    public void setChildren(List<Human> children){
        this.children=children;
    }

    public Human getFather() {
        return father;
    }
}
