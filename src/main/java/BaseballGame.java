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
            int strikeCount = judge(computerNumber, parseUserNumber(userInput));

            programCount += 1;

            if(strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.\n");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                endNumber = s.nextInt();
                programCount = 0;
                computerNumber = computerNumber();
            }

            if (programCount == 9){
                System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.\n");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                endNumber = s.nextInt();
                programCount = 0;
                computerNumber = computerNumber();
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

        else if (strikeCount != 0 && ballCount == 0){
            StringBuilder strike = new StringBuilder();
            strike.append(strikeCount);
            strike.append(" 스트라이크");
            System.out.println(strike);
        }

        else if (strikeCount == 0 && ballCount != 0){
            StringBuilder ball = new StringBuilder();
            ball.append(ball);
            ball.append(" 볼");
            System.out.println(ball);
        }
        else{
            StringBuilder stringResult = new StringBuilder();
            stringResult.append(strikeCount);
            stringResult.append(" 스트라이크");
            stringResult.append(ballCount);
            stringResult.append(" 볼");
        }

        System.out.println("스트라이크 : "+strikeCount+", 볼 : "+ballCount);

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

    static int[] parseUserNumber(int userInput) {
        int[] userNumber = new int[3];

        userNumber[0] = userInput/100;
        userNumber[1] = userInput%100/10;
        userNumber[2] = userInput%10;

        return userNumber;
    }

    static int[] computerNumber() {
        int max=9;

        int[] baseballNumber = new int[3];
        Random createRandom = new Random();

        for (int i = 0; i < 3; i++) {
            int computerNumber = createRandom.nextInt(max);
            baseballNumber[i] += computerNumber;
            for(int j=0; j <i; j++)
            {
                if (baseballNumber[i] == baseballNumber[j]){
                    i--;
                }
            }
        }
        System.out.println(baseballNumber[0]);
        System.out.println(baseballNumber[1]);
        System.out.println(baseballNumber[2]);
        return baseballNumber;
    }
}
