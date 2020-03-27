package homework13.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Family implements Serializable {
    private static int idCounter=1;
    private int index;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets = new HashSet<>();
    private int countOfFamily;

    public Family(Human mother, Human father){
        this.mother=mother;
        this.father=father;
        this.children= new ArrayList<>();
        this.index=idCounter++;
        countFamily();
    }
    public Family(int id, Human mother, Human father){
        this(mother,father);
        this.index=id;
    }


    public int countFamily(){
        this.countOfFamily =2;//two parents
        this.countOfFamily +=this.children.size();
        return countOfFamily;
    }

    public void setMother(Human mother){
        this.mother=mother;
    }
    public void setFather(Human father){
        this.father=father;
    }
    public void setCount(int count) {
        this.countOfFamily = count;
    }

    public void setChildren(List<Human> children){
        this.children =children;
        this.countFamily();
    }
    public void addPet(Pet pet){
        this.pets.add(pet);
    }
    public Human getMother(){
        return this.mother;
    }
    public Human getFather(){
        return this.father;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public int getIndex() {
        return this.index;
    }
    public List<Human> getChildren(){
        return this.children;
    }

    public Set<Pet> getPets() {
        return pets;
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
        this.countFamily();
        return countOfChildren < children.size();
    }

    public boolean deleteChild(Human human){
        int countOfChildren = children.size();
        children.remove(human);
        this.countFamily();
        return countOfChildren < children.size();
    }
    public boolean addChild(Human child){
        int countOfChildren = children.size();
        this.children.add(child);
        this.countFamily();
        return countOfChildren > children.size();
    }

    @Override
    public String toString(){
        return String.format("Family{ID=%d,father=%s %s,mother=%s %s,children=%s,pet=%s,count of family=%d}",this.index,
                this.father.getName(), this.father.getSurname(),this.mother.getName(),
                this.mother.getSurname(), this.children.toString(),
                this.pets.toString(),
                this.countOfFamily);
    }


    public String prettyFormat(){
        StringBuffer sb = new StringBuffer();
        this.children.forEach(human -> sb.append(String.format("%s:%s\n                     ",human.getGender(),human.prettyFormat())));
        sb.append("\n            pets:");
        sb.append("[");
        this.pets.forEach(pet -> sb.append(pet.prettyFormat()));
        sb.append("]");


        return String.format("Family:\n       ID=%d, mother:{%s},\n        father:{%s},\n            " +
                "children:\n                     %s",this.index,this.mother.prettyFormat(),this.father.prettyFormat(),sb.toString());
    }


    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family)o;
        return family.father.equals(this.father) && family.mother.equals(this.mother) && family.index == this.index;
    }
    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }
}
