import java.util.Scanner;
import java.util.Random;

public class BaseballGame{
    public static void main(String[] args){
        // 여기 안에 코드 작성하는 것
        Random createRandom = new Random();

        for(int i=0; i < 3; i++){
            int computerNumber = createRandom.nextInt(9);
            int[] baseballNumber = new int[3];
            baseballNumber[i] = computerNumber;
            System.out.println(baseballNumber[i]);
        }

        for(int i = 1; i <= 9; i++){
            Scanner s = new Scanner(System.in);
            System.out.println("숫자를 입력해주세요 : ");
            double userInput = s.nextInt();
        }

        int[] userNumber = new int[3];

        System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.\n");
    }
}