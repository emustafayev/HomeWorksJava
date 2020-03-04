package homework3;

import java.util.Scanner;

public class WeekPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] schedule = new String[7][2];
        schedule[0][0] = "Monday";
        schedule[0][1] = "Do Home Work";
        schedule[1][0] = "Tuesday";
        schedule[1][1] = "Go to course, Watch a film";
        schedule[2][0] = "Wednesday";
        schedule[2][1] = "Sleep all day!";
        schedule[3][0] = "Thursday";
        schedule[3][1] = "Go to the university";
        schedule[4][0] = "Friday";
        schedule[4][1] = "Sleep Again";
        schedule[5][0] = "Saturday";
        schedule[5][1] = "Weekend sleep";
        schedule[6][0] = "Sunday";
        schedule[6][1] = "Prepare my homework!";

        while (true) {
            System.out.println("Please, input the day of the week: ");
            String day_of_week = sc.nextLine();
            boolean brk=false;
            day_of_week = day_of_week.trim().toLowerCase();
            boolean found =false;
            for(int i = 0;i<7;i++){
                if(schedule[i][0].equalsIgnoreCase(day_of_week) || "exit".equalsIgnoreCase(day_of_week) ){
                    found=true;
                    break;
                }
            }
            if(found){
                switch (day_of_week) {
                    case "monday":
                        System.out.println(schedule[0][1]);
                        break;
                    case "tuesday":
                        System.out.println(schedule[1][1]);
                        break;
                    case "wednesday":
                        System.out.println(schedule[2][1]);
                        break;
                    case "thursday":
                        System.out.println(schedule[3][1]);
                        break;
                    case "friday":
                        System.out.println(schedule[4][1]);
                        break;
                    case "saturday":
                        System.out.println(schedule[5][1]);
                        break;
                    case "sunday":
                        System.out.println(schedule[6][1]);
                        break;
                    case "exit":
                        System.out.println("Bye");
                        brk = true;

                }
            }else{
                System.out.println("Sorry, I don't understand you, please try again.");
            }

            if (brk){
                break;
            }
        }


    }

}