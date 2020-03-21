package homework6;

import java.util.Arrays;
import java.util.stream.Collectors;


public class HappyFamily {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    public static int count;

    public HappyFamily(Human mother, Human father){
        Human[] children = new Human[] {};
        this.mother=mother;
        this.father=father;
        this.children=children;
    }
    public HappyFamily(Human mother, Human father, Pet pet){
        Human[] children = new Human[] {};
        this.mother=mother;
        this.father=father;
        this.children=children;
        this.pet = pet;
    }
    public HappyFamily(){}

    public int countFamily(){
        HappyFamily.count=2;//to parents
        HappyFamily.count+=this.children.length;
        return HappyFamily.count;
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

    public Human[] addChildren(Human[] children){
        this.children=children;
        this.countFamily();
        return this.children;
    }
    public boolean deleteChild(int index){
        boolean removed=false;
        if(index<children.length){
            Human[] result = new Human[children.length-1];
            removed = remove(this.children,index,result);
            this.countFamily();
        }
        return removed;
    }

    public boolean deleteChild(Human human){
        boolean removed=false;
        int length = Arrays.stream(children).filter(h -> h.equals(human)).toArray().length;
        if(length<children.length){
            Human[] result= new Human[children.length-length];
            Arrays.stream(children).filter(h -> !h.equals(human)).collect(Collectors.toList()).toArray(result);
            removed=true;
            this.countFamily();
            this.children=result;
        }
        return removed;
    }
    public boolean addChild(Human child){
        Human[] result;
        try {
           result = Arrays.copyOf(this.children,this.children.length+1);
           this.children[this.children.length-1] = child;
            this.children=result;
            this.countFamily();
            return true;
        }catch (Exception e){
            return false;
        }
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
        return String.format("Family{father=%s %s,mother=%s %s,children=%s,pet=%s,}",
                this.father.getName(), this.father.getSurname(),this.mother.getName(),
                this.mother.getSurname(), Arrays.toString(this.children),
                this.pet.nickname);
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HappyFamily family = new HappyFamily();
        return Arrays.equals(this.pet.habits,family.pet.habits);
    }
    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }

}
