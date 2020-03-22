package homework7;

import java.util.Arrays;

public abstract class Pet {
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits = new String[5];


    public Pet(String nickname, int age, int trickLevel){
        this.nickname = nickname;
        this.age=age;
        this.trickLevel=trickLevel;
    }

    public void eat(){
        System.out.println("I am eating!");
    }

    public abstract void response();


    @Override
    public String toString(){
        return String.format("pet={nickname=%s, age=%d,tricklevel=%d,hapits=%s",this.nickname,this.age,this.trickLevel, Arrays.toString(this.habits));
    }
}
