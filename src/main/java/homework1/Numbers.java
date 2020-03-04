package homework1;


import java.util.*;

public class Numbers {

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static int[] addNumber(int[] numbers, int num) {
        int[] temp = new int[numbers.length + 1];

        for (int i = 0; i < numbers.length; i++){
            temp[i] = numbers[i];
        }
        return temp;
    }


    private static void first_game(String name, Scanner sc) {
        Random rand = new Random();

        int number = rand.nextInt(101);
        System.out.println(number);
        int[] numbers = new int[0];
        int count=0;
        while (true) {
            String userguess = sc.next();
            if (isNumeric(userguess)) {
                int num = Integer.parseInt(userguess);
                numbers = addNumber(numbers, num);
                numbers[count++] = num;
                if (num < number) {
                    System.out.println("Your number is too small. Please, try again.");
                } else if (num > number) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    Arrays.sort(numbers);
                    System.out.print("Entered numbers: ");
                    for(int i=numbers.length-1;i>=0;i--){
                        System.out.printf("%d ",numbers[i]);
                    }
                    System.out.printf("\nCongratulations, %s!", name);
                    break;
                }
            } else {
                System.out.println("Please enter in correct format!");
                String str = String.valueOf(6);
                System.out.println(str);
            }
        }
    }


    private static void second_game(String name, Scanner sc,int number) {
        Random rand = new Random();

        System.out.println(number);
        int[] numbers = new int[0];
        int count=0;
        while (true) {
            String userguess = sc.next();
            if (isNumeric(userguess)) {
                int num = Integer.parseInt(userguess);
                numbers = addNumber(numbers, num);
                numbers[count++] = num;
                if (num < number) {
                    System.out.println("Your number is too small. Please, try again.");
                } else if (num > number) {
                    System.out.println("Your number is too big. Please, try again.");
                } else {
                    Arrays.sort(numbers);
                    System.out.print("Entered numbers: ");
                    for(int i=numbers.length-1;i>=0;i--){
                        System.out.printf("%d ",numbers[i]);
                    }
                    System.out.printf("\nCongratulations, %s!", name);
                    break;
                }
            } else {
                System.out.println("Please enter in correct format!");
            }

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Let the game begin!");
        System.out.println("Choose 1 for random number find game");
        System.out.println("Choose 2 for find events date");
        System.out.println("Wating for input...");
        int choice = sc.nextInt();


        if (choice == 1) {
            first_game(name, sc);
        }
        else {
            Integer[][] events = new Integer[3][3];
            events[0][0] = 1;
            events[0][1] = 1939;
            events[1][0] = 2;
            events[1][1] = 1999;
            events[2][0] = 3;
            events[2][1] = 2020;
            System.out.println("1. When did WWII begin?");
            System.out.println("2. When did Afgan birth?");
            System.out.println("3. When did start second part of project of IBA?");
            int question = sc.nextInt();
            int number=0;
            switch(question){
                case 1:
                    number = events[question-1][1];
                    break;
                case 2:
                    number = events[question-1][1];
                    break;
                case 3:
                    number = events[question-1][1];
                    break;
            }
            second_game(name, sc, number);

        }
    }

}
