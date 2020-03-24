package homework8;

import java.util.List;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setChildren(List<Human> children){
        this.children=children;
    }

    public Human getFather() {
        return father;
    }
}
