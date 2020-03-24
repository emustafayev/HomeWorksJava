package homework11;


import java.util.HashSet;
import java.util.Set;

public class Pet {
    public String nickname;
    public int age;
    public int trickLevel;
    public Set<String> habits = new HashSet<>();
    Species species;


    public Pet(String nickname, int age, int trickLevel, Species spc){
        this.nickname = nickname;
        this.age=age;
        this.trickLevel=trickLevel;
        this.species=spc;
    }

    public void setHabits(String habits) {
        this.habits.add(habits);
    }

    public void eat(){
        System.out.println("I am eating!");
    }



    @Override
    public String toString(){
        return String.format("pet={nickname=%s, age=%d,tricklevel=%d",this.nickname,this.age,this.trickLevel);
    }
}
