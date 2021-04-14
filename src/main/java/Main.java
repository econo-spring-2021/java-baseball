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
        int input;
        for (int i = 0; i < 9; i++) {
            input = getInput();
            getHint(input, answer);
        }

    }

    public static int getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        return input;
    }

    public static int[] getHint(int input, int[] answer) {
        int[] inputs = new int[3];
        int strike = 0;
        int ball = 0;
        for (int i = 2; i >= 0; i--) {
            inputs[i] = input % 10;
            input = input / 10;
        }

        for(int i=0;i<3;i++){
            if(answer[0] == inputs[i] && i==0){
                strike++;
            }else if(answer[0] == inputs[i] && i!=0){
                ball++;
            }

            if(answer[1]==inputs[i] && i==1){
                strike++;
            }else if(answer[1] == inputs[i] && i!=1){
                ball++;
            }

            if(answer[2]==inputs[i] && i==2){
                strike++;
            }else if(answer[2] == inputs[i] && i!=2){
                ball++;
            }
        }

        int[] hint = {strike,ball};
        return hint;

    }

}
