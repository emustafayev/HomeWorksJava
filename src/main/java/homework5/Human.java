package homework5;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    public String name;
    public String surname;
    public int date_of_birth;
    public int IQ_level;

    public Human(String name, String surname, int date_of_birth){
        this.name=name;
        this.surname=surname;
        this.date_of_birth=date_of_birth;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, surname,date_of_birth,IQ_level);
    }

    @Override
    public String toString(){
        return String.format("Human{name=%s, surname=%s, year=%d, iq=%d",
                name,surname,date_of_birth,IQ_level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return date_of_birth == human.date_of_birth &&
                name.equals(human.name) &&
                surname.equals(human.surname);
    }
}