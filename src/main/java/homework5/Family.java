package homework5;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    public static int count;

    public Family(Human mother, Human father){
        this.children = new Human[]{};
        this.mother=mother;
        this.father=father;
    }

    public void countFamily(){
        Family.count=2;//two parents
        Family.count+=this.children.length;
    }

    public void setMother(Human mother){
        this.mother=mother;
    }
    public void setFather(Human father){
        this.father=father;
    }
    public void setChildren(Human[] children){
        this.children =children;
        this.countFamily();
    }
    public void setPet(Pet pet){
        this.pet=pet;
    }
    public Human getMother(){
        return this.mother;
    }
    public Human getFather(){
        return this.father;
    }
    public Human[] getChildren(){
        return this.children;
    }
    public Pet getPet(){
        return this.pet;
    }

    public void addChildren(Human[] children){
        this.children=children;
        this.countFamily();
    }

    public boolean deleteChild(Human human){
        boolean removed=false;
        Human[] newArr = new Human[this.children.length-1];
        int index=0;
        for (Human child : this.children) {
            if (!child.equals(human)) {
                newArr[index++] = child;
            }
        }
        this.children=newArr;
        if(index<children.length-1){
            removed=true;
        }
        return removed;
    }

    private boolean remove(Human[] children, int index, Human[] result) {
        try {
            System.arraycopy(children, 0, result,0,index);
            System.arraycopy(children, index+1,result,index,result.length-1);
            this.children=result;
            return true;
        }catch (Exception e){
            return false;
        }

    }


    @Override
    public String toString(){
        return String.format("Family{father=%s %s,mother=%s %s,children=%s,pet=%s,}",this.father.name, this.father.surname,this.mother.name, this.mother.surname, Arrays.toString(this.children),this.pet.nickname);
    }

                  
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Family family = (Family)o;
        return this.mother.name.equals(family.mother.name)
                && this.father.name.equals(family.mother.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mother,father,children);
    }

}
