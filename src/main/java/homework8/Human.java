package homework8;

import homework6.Pet;

public class Human {
    public String name;
    public String surname;
    public int date_of_birth;
    public int IQ_level;
    public Pet pet;



    public Human(String name, String surname, int date_of_birth,int IQ_level, Pet pet){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
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
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d,pet={nickname=%s, age=%d,tricklevel=%d",
                name,surname,date_of_birth,IQ_level,pet.nickname,pet.age,pet.trickLevel);
    }

    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }

    public static void main(String[] args) {
        System.gc();
    }

}
