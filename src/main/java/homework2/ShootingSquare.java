package homework2;

import java.util.Random;
import java.util.Scanner;

public class ShootingSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int TARGET_X = rand.nextInt(5);
        int TARGET_Y = rand.nextInt(5);
        char[][] Board = new char[5][5];
        for(int i = 0;i<5;i++){
            for (int j=0;j<5;j++){
                Board[i][j] = '-';
            }
        }
        System.out.println("All set. Get ready to rumble!");


        int user_x;
        int user_y;
        while(true){
            System.out.println("Enter the coordinate X:(1-5) ");
            user_x = sc.nextInt();
            System.out.println("Enter the coordinate Y:(1-5) ");
            user_y = sc.nextInt();
            int n = horizontalVerticalTarget();
            if (n==1){
                int TARGET_Y2 = TARGET_Y+1;
                int TARGET_Y3 = TARGET_Y-1;
            }else {
                int TARGET_X2 = TARGET_X+1;
                int TARGET_X3 = TARGET_X-1;
            }
            if(user_x>=1 && user_x<=5 && user_y>=1 && user_y<=5){
                if(user_x == TARGET_X+1 && user_y == TARGET_Y+1){
                    System.out.println("You have won!");
                    Board[user_x-1][user_y-1] = 'X';
                    System.out.println(" 1 2 3 4 5");
                    for(int i = 0;i<5;i++){
                        System.out.printf("%d ",i+1);
                        for (int j=0;j<5;j++){
                            System.out.printf("%c ",Board[i][j]);;
                        }
                        System.out.println();
                    }
                    break;
                }else{
                    Board[user_x-1][user_y-1] = '*';
                    System.out.println("  1 2 3 4 5");
                    for(int i = 0;i<5;i++){
                        System.out.printf("%d ",i+1);
                        for (int j=0;j<5;j++){
                            System.out.printf("%c ",Board[i][j]);;
                        }
                        System.out.println();
                    }
                }
            }else{
                System.out.println("Inputs are wrong!");
            }
        }
    }

    private static Integer horizontalVerticalTarget() {
        return ((int)(Math.random()*2));
    }
}
