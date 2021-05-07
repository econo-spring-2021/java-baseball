import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;
import java.util.Random;

public class BaseballGame{
    public static void main(String[] args){
        Random createRandom = new Random();
        int[] baseballNumber = new int[3];

        for(int i=0; i < 3; i++){
            int computerNumber = createRandom.nextInt(9);
            baseballNumber[i] = computerNumber;
            System.out.println(baseballNumber[i]);
        }

        for(int i = 0; i < 9; i++){
            Scanner s = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요 : ");
            int userInput = s.nextInt();

            int indexInput = 0;
            int[] userNumber = new int[3];

            for (int j = 2; j >= 0; j--){
                indexInput = (int) (userInput%10);
                userNumber[j] = indexInput;
                userInput /= 10;
            }



            judge(baseballNumber, userNumber);
        }

        System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.\n");
    }

    static void judge(int[] baseballNumber, int[] userNumber){
        int strikeCount = 0;
        int ballCount = 0;

        for(int i=0; i <(baseballNumber.length); i++){
            if(baseballNumber[i] == userNumber[i]){
                strikeCount += 1;
            }
            else if (baseballNumber[i] != userNumber[i]){
                int compareNumber = baseballNumber[i];
                ballCount += findBall(compareNumber, userNumber);
            }
        }
        System.out.println("strikeCount : " + strikeCount);
        System.out.println("ballCount : " + ballCount);
    }

    static int findBall(int compareNumber, int[] userNumber){
        int sameCount = 0;
        for(int i = 0; i <userNumber.length; i++){
            if (compareNumber == userNumber[i]){
                 sameCount += 1;
            }
        }
        return sameCount;
    }
}