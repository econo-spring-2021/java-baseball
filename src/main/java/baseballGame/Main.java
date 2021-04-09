package baseballGame;

import java.util.Scanner;

public class Main {

    public static boolean askWillRetry() {
        return false;
    }

    public static void playGame() {
        Scanner console = new Scanner(System.in);
        for (int cnt = 0; cnt < 9; cnt++) {
            System.out.print("숫자를 입력해주세요 : ");
            int input = console.nextInt();
            int[] ball = new int[3];
            for (int i = 0; i < 3; i++) {
                ball[i] = input % 10;
                input /= 10;
            }

            // checkBallAvailbility() with result Class

            // returnIsPlayerWin()
        }
    }

    public static void main(String[] args) {
        boolean willRetry;
        do {
            playGame();

            willRetry = askWillRetry();
        } while (willRetry);
    }
}
