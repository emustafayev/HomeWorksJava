package homework7;

enum Species{
    CAT,DOG,ROBOCAT,UNKNOWN
}

public class Main {
    public static void main(String[] args) {

        RoboCat robo = new RoboCat(Species.ROBOCAT,"Robby",10,50,new String[]{"stupid,hardworking"});
        System.out.println(robo.nickname);
        System.out.println(robo.species);
        System.out.println(robo.toString());
        robo.response();

        Man man = new Man("Name",Species.CAT);
        man.greetPet();

    }
}
