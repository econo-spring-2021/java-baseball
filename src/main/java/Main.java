import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] answer = setRandomNum();
        playBaseball(answer);
    }

    public static int[] setRandomNum() {
        int[] answer = new int[3];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int) (Math.random() * 10);
        }
        return answer;
    }

    public static void playBaseball(int[] answer) {
        for (int i = 0; i < 9; i++) {
            getInput();
        }

    }
    public static int getInput(){
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }


}
