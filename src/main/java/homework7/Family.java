package homework7;

public class Family {
    private Human mother;
    private Human father;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }
}
