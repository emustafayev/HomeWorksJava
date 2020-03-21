package homework6;


import java.util.Arrays;

public class Human {
    private String name;
    private String surname;
    private int date_of_birth;
    private int IQ_level;
    private Pet pet;
    private Schedule humanActivity;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Human(String name, String surname, int date_of_birth){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
    }
    public Human(String name, String surname, int date_of_birth, Human father, Human mother){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
    }
    public Human(String name, String surname, int date_of_birth, Human father, Human mother, Pet pet, int IQ_level){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
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
        return String.format("Human{name=%s, surname=%s, year=%d",
                name,surname,date_of_birth);
    }

    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }

    public static void main(String[] args) {
        System.gc();
    }

}

enum Schedule{
    MONDAY("read book"),
    TUESDAY("Sleep"),
    WEDNESDAY("Code..."),
    THURSDAY("Sleep"),
    FRIDAY("Walking"),
    SATURDAY("Resting"),
    SUNDAY("Nothing");

    private String activity;
    Schedule(String action) {
        this.activity =action;
    }

    public String getActivity() {
        return activity;
    }
    public void setNewActivity(String newActivity){
        this.activity =newActivity;
    }
}
