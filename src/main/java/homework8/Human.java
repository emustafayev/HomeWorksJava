package homework8;


import java.util.HashMap;

public class Human {
    public String name;
    public String surname;
    public int date_of_birth;
    public int IQ_level;
    public HashMap<Schedules,String> activity;


    public Human(String name, String surname, int date_of_birth, int iq){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
        this.IQ_level = iq;
    }

    public Human(String name, String surname, int date_of_birth,int IQ_level, Pet pet, HashMap<Schedules,String> activities){
        this(name, surname, date_of_birth,IQ_level);
        this.activity=activities;
    }


    @Override
    public String toString(){
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d",
                name,surname,date_of_birth,IQ_level);
    }

    @Override
    public void finalize(){
        System.out.println("Object removed from memory!");
    }

    public static void main(String[] args) {
        System.gc();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
}


