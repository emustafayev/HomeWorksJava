package homework6;


import java.util.Arrays;

public class Human {
    public String name;
    public String surname;
    public int date_of_birth;
    public int IQ_level;
    public Pet6 pet;
    public Human mother;
    public Human father;

    public Human(String name, String surname, int date_of_birth){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
    }
    public Human(String name, String surname, int date_of_birth, Human father, Human mother){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
        this.father=father;
        this.mother=mother;
    }
    public Human(String name, String surname, int date_of_birth, Human father, Human mother, Pet6 pet, int IQ_level){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
        this.father=father;
        this.mother=mother;
        this.IQ_level=IQ_level;
        this.pet = pet;
    }
    public Human(){}//Cant refactor HUman class according to homework5, because homework4 not checked yet.

    public void greetPet(){
        System.out.printf("Hello, %s",this.pet.nickname);
    }
    public  void describePet(){
        if(this.pet.trickLevel>50) {
            System.out.printf("I have a %s, he is %d years old he is very sly",this.pet.species, this.pet.age);
        }else{
            System.out.printf("I have a %s, he is %d years old he is almost not sly",this.pet.species, this.pet.age);
        }
    }

    @Override
    public String toString(){
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d, mother=%s %s, father=%s %s,pet={nickname=%s, age=%d,tricklevel=%d,hapits=%s",
                name,surname,date_of_birth,IQ_level,mother.name,mother.surname,
                father.name,father.surname,pet.nickname,pet.age,pet.trickLevel,
                Arrays.toString(pet.habits));
    }

    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }

    public static void main(String[] args) {
        System.gc();
    }

}
