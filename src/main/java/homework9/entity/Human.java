package homework9.entity;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    public String name;
    public String surname;
    public int date_of_birth;
    public int IQ_level;
    public Map<Schedules,String> activity;


    public Human(String name, String surname, int date_of_birth, int iq){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
        this.IQ_level = iq;
    }

    public Human(String name, String surname, int date_of_birth, int IQ_level, HashMap<Schedules,String> activities){
        this(name, surname, date_of_birth,IQ_level);
        this.activity=activities;
    }


    @Override
    public String toString(){
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d",
                name,surname,date_of_birth,IQ_level);
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return date_of_birth == human.date_of_birth &&
                IQ_level == human.IQ_level &&
                Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, date_of_birth, IQ_level);
    }
}


