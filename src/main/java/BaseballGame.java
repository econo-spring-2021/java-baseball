import java.util.Scanner;
import java.util.Random;

public class BaseballGame {
    public static void main(String[] args) {
        int endNumber = 0;
        int programCount = 0;
        Scanner s = new Scanner(System.in);
        int computerNumber[] = computerNumber();

        while (endNumber != 2) {

            System.out.println("숫자를 입력해주세요 : ");
            int userInput = s.nextInt();
            int strikeCount = judge(computerNumber, userNumber(userInput));

            programCount += 1;
            System.out.println(programCount);

            if(strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.\n");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                programCount = 0;
                computerNumber();
                endNumber = s.nextInt();
            }

            if (programCount == 9){
                System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.\n");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                programCount = 0;
                computerNumber();
                endNumber = s.nextInt();
            }
        }
    }

    static int judge(int[] computerNumber, int[] userNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < (computerNumber.length); i++) {
            if (computerNumber[i] == userNumber[i]) {
                strikeCount += 1;
            } else if (computerNumber[i] != userNumber[i]) {
                int compareNumber = computerNumber[i];
                ballCount += findBall(compareNumber, userNumber);
            }
        }

        if (strikeCount == 0 && ballCount==0){
            System.out.println("볼넷");
        }
        else{
            System.out.println(strikeCount+" 스트라이크" +" , "+ballCount+" 볼");
        }
        return strikeCount;
    }

    static int findBall(int compareNumber, int[] userNumber) {
        int sameCount = 0;
        for (int i = 0; i < userNumber.length; i++) {
            if (compareNumber == userNumber[i]) {
                sameCount += 1;
            }
        }
        return sameCount;
    }

    static int[] userNumber(int userInput) {
        int[] userNumber = new int[3];

        userNumber[0] = userInput/100;
        userNumber[1] = userInput%100/10;
        userNumber[2] = userInput%10;

        return userNumber;
    }

    static int[] computerNumber() {
        Random createRandom = new Random();
        int[] baseballNumber = new int[3];

        for (int i = 0; i < 3; i++) {
            int computerNumber = createRandom.nextInt(9);
            baseballNumber[i] = computerNumber;
        }
        return baseballNumber;
    }
}