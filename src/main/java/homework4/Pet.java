package homework4;

import java.util.Arrays;

public class Pet {
    public String species;
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits = new String[5];

    public Pet(String species,String nickname ){
        this.species = species;
        this.nickname = nickname;
    }
    public Pet(String species, String nickname, int age, int trickLevel,String[] habits){
        this.nickname = nickname;
        this.species = species;
        this.age=age;
        this.trickLevel=trickLevel;
        this.habits=habits;
    }
    public Pet(){}

    public void eat(){
        System.out.println("I am eating");
    }
    public void response(){
        System.out.printf("Hello, owner. I am %s. I miss you ",this.nickname);
    }
    public void foul(){
        System.out.println("I need to cover it up!");
    }


    @Override
    public String toString(){
        return String.format("pet={nickname=%s, age=%d,tricklevel=%d,hapits=%s",this.nickname,this.age,this.trickLevel, Arrays.toString(this.habits));
    }
}
