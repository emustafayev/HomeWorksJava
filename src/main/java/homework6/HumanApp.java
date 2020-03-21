package homework6;


import homework5.Family;

public class HumanApp {
    public static void main(String[] args) {
        Human father =new Human("Dada","SurnameDADA",1978);
        Human mother = new Human("Mom","MomSurname",1984);
        Pet pet1 = new Pet(Species.CAT,"Kotty");
        HappyFamily family = new HappyFamily(mother,father,pet1);

        Human child1 = new Human("NameChild1","Surnamechild1",1999);
        Human child2 = new Human("NameChild2","Surnamechild2",1996);
        Human child3 = new Human("NameChild3","SurnameChild3",2001);
        Human child4 = new Human("NameChild4","SurnameChild4",2001);


        Human[] children = new Human[]{ child1,child2,child3};
        family.deleteChild(child4);
        family.addChildren(children);
        Human[] childrenAfterDelete = family.getChildren();
        System.out.println(childrenAfterDelete.length);
        for (Human human : childrenAfterDelete) {
            System.out.println(human);
        }
        System.out.println(family);



//        for (long i = 0; i < 10000000000L; i++) {
//            new Family();
//        }


    }
}
