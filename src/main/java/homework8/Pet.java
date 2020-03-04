package homework8;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pet {
    public String nickname;
    public int age;
    public int trickLevel;
    public Set<String> habits = new HashSet<String>();
    Species species;

    public Pet(String nickname ){
        this.nickname = nickname;
    }
    public Pet(String nickname, int age, int trickLevel, String[] habits, Species spc){
        this.nickname = nickname;
        this.age=age;
        this.trickLevel=trickLevel;
        this.habits.addAll(Arrays.asList(habits));
        this.species=spc;
    }

    public void eat(){
        System.out.println("I am eating!");
    }



    @Override
    public String toString(){
        return String.format("pet={nickname=%s, age=%d,tricklevel=%d",this.nickname,this.age,this.trickLevel);
    }
}
