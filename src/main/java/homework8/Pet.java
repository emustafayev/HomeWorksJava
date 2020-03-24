package homework8;

import java.util.Set;

public abstract class Pet {
    public String nickname;
    public int age;
    public int trickLevel;
    public Set<String> habits;


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
        return String.format("pet={nickname=%s, age=%d,tricklevel=%d,hapits=%s",this.nickname,this.age,this.trickLevel, this.habits.toString());
    }
}
