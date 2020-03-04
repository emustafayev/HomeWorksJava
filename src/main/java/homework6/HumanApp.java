package homework6;


public class HumanApp {
    public static void main(String[] args) {
        Species spc1 = Species.CAT;
        Human father =new Human("Dada","SurnameDADA",1978);
        Human mother = new Human("Mom","MomSurname",1984);
        Pet6 pet1 = new Pet6(spc1,"Kotty");
        HappyFamily family = new HappyFamily(mother,father,pet1);
        Human child1 = new Human("NameChild1","Surnamechild1",1999);
        Human child2 = new Human("NameChild2","Surnamechild2",1996);

        Human[] children = new Human[]{ child1,child2} ;
        family.addChildren(children);
        family.deleteChild(1);
        boolean res = family.equals(family);
        Human for_add_child = new Human("NameChild3","SurnameChild3",2001);
        boolean added = family.addChild(for_add_child);
        if(res != true && added !=true){
            System.gc();
        }
    }
}
