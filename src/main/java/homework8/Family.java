package homework8;


import java.util.*;
import java.util.stream.Collectors;


public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet = new HashSet<>();
    public static int count;

    public Family(Human mother, Human father){
        this.mother=mother;
        this.father=father;
        this.children= new ArrayList<>();
    }


    public void countFamily(){
        Family.count=2;//two parents
        Family.count+=this.children.size();
    }

    public void setMother(Human mother){
        this.mother=mother;
    }
    public void setFather(Human father){
        this.father=father;
    }

    public void setChildren(List<Human> children){
        this.children =children;
        this.countFamily();
    }
    public void addPet(Pet pet){
        this.pet.add(pet);
    }
    public Human getMother(){
        return this.mother;
    }
    public Human getFather(){
        return this.father;
    }
    public List<Human> getChildren(){
        return this.children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public List<Human> addChildren(List<Human> children){
        this.children=children;
        this.countFamily();
        return this.children;
    }
    public boolean deleteChild(int index){
        boolean removed=false;
        int countOfChildren = children.size();
        children.remove(index);
        return countOfChildren < children.size();
    }

    public boolean deleteChild(Human human){
        int countOfChildren = children.size();
        children.remove(human);
        return countOfChildren < children.size();
    }
    public boolean addChild(Human child){
        int countOfChildren = children.size();
        this.children.add(child);
        return countOfChildren > children.size();
    }

    @Override
    public String toString(){
        return String.format("Family{father=%s %s,mother=%s %s,children=%s,pet=%s,}",
                this.father.getName(), this.father.getSurname(),this.mother.getName(),
                this.mother.getSurname(), this.children.toString(),
                this.pet.toString());
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family)o;
        return family.father.equals(this.father) && family.mother.equals(this.mother);
    }
    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }
}
