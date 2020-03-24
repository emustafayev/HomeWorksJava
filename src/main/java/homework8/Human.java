package homework8;

import java.util.Map;
import java.util.Objects;

public class Human {
    public String[] names = new String[]{"John","Alex","Steve"};
    String name;
    Family family;
    private int IQ;
    private Map<Schedules,String> schedulesMap;


    public Human(String n, Family family_ref, int iq){
        this.name=n;
        this.family = family_ref;
        this.IQ=iq;
    }

    public void greetPet(){}

    public Human(String n, Family family_ref, int iq,Map<Schedules,String> schedulesMap ){
        this(n,family_ref,iq);
        this.schedulesMap = schedulesMap;
    }

    public int getIQ() {
        return IQ;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return IQ == human.IQ &&
                family.equals(human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, IQ);
    }
}
