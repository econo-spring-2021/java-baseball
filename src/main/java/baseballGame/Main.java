package baseballGame;

import java.util.Scanner;

class BallAvailbilty {
    private boolean isBoB;
    private int strikeCnt;
    private int ballCnt;

    public BallAvailbilty(boolean isBob) {
        this.isBoB = isBob;
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public BallAvailbilty(int strikeCnt, int ballCnt) {
        this.isBoB = false;
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public boolean getIsBob() { return isBoB; }
    public int getStrikeCnt() { return  strikeCnt; }
    public int getBallCnt() { return ballCnt; }
}

public class Main {

    public static boolean askWillRetry(int[] ball) {
        return false;
    }

    public static BallAvailbilty returnBallAvailability() {

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

            BallAvailbilty ballAvailbilty = returnBallAvailability(ball);
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
