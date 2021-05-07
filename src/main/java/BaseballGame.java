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
        for(int i=0; i <(baseballNumber.length); i++){
            if(baseballNumber[i] == userNumber[i]){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.\n");
            }
        }
    }
}