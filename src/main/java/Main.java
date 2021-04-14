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
        StringBuilder hint;
        System.out.println(answer[0] + ""+answer[1]+""+answer[2]);
        for (int i = 0; i < 9; i++) {
            input = getInput();
            hint = printHint(getHint(input, answer));
            System.out.println(hint);
            if(hint.toString().equals("3 스트라이크 아웃")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.");
                break;
            }
            if(i==8){
                System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.");
            }
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

    public static StringBuilder printHint(int[] hint){
        int strike = hint[0];
        int ball = hint[1];

        StringBuilder sb = new StringBuilder();
        if(strike !=0 && ball != 0){
          sb.append(strike).append("스트라이크").append(ball).append("볼");
        }else if(strike == 0 && ball ==0){
            sb.append("볼넷");
        }else if(strike == 0 && ball !=0){
           sb.append(ball).append("볼");
        }else if(strike !=0 && strike !=3 && ball ==0 ){
            sb.append(strike).append("스트라이크");
        }else if(strike == 3){
            sb.append("3 스트라이크 아웃");
        }
        return sb;
    }

}
