import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] answer = setRandomNum();
        boolean replay;
        do {
            playBaseball(answer);
            replay = askReplay();
        } while (replay);

    }

    public static int[] setRandomNum() {
        int[] answer = new int[3];

        answer[0] = checkZeroNum();

        do {
            answer[1] = checkZeroNum();
        } while (answer[0] == answer[1]);

        do {
            answer[2] = checkZeroNum();
        } while (answer[0] == answer[2] || answer[1] == answer[2]);

        return answer;
    }

    public static int checkZeroNum() {
        int random;
        do {
            random = (int) (Math.random() * 10);
        } while (String.valueOf(random).contains("0"));
        return random;
    }

    public static void playBaseball(int[] answer) {
        int input;
        StringBuilder hint;

        for (int i = 0; i < 9; i++) {
            input = getInput();
            hint = printHint(getHint(input, answer));
            System.out.println(hint);
            if (hint.toString().equals("3 스트라이크 아웃")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.");
                break;
            }
            if (i == 8) {
                System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.");
            }
        }

    }

    public static int getInput() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        checkInput(input);
        return input;
    }

    public static void checkInput(int input) {
        if (input < 100 || input > 999) {
            getInput();
        }
    }

    public static int[] getHint(int input, int[] answer) {
        int[] inputs = new int[3];
        int strike = 0;
        int ball = 0;
        for (int i = 2; i >= 0; i--) {
            inputs[i] = input % 10;
            input = input / 10;
        }

        for (int i = 0; i < 3; i++) {
            if (answer[0] == inputs[i] && i == 0) {
                strike++;
            } else if (answer[0] == inputs[i] && i != 0) {
                ball++;
            }

            if (answer[1] == inputs[i] && i == 1) {
                strike++;
            } else if (answer[1] == inputs[i] && i != 1) {
                ball++;
            }

            if (answer[2] == inputs[i] && i == 2) {
                strike++;
            } else if (answer[2] == inputs[i] && i != 2) {
                ball++;
            }
        }

        int[] hint = {strike, ball};
        return hint;

    }

    public static StringBuilder printHint(int[] hint) {
        int strike = hint[0];
        int ball = hint[1];

        StringBuilder sb = new StringBuilder();
        if (strike != 0 && ball != 0) {
            sb.append(strike).append("스트라이크").append(ball).append("볼");
        } else if (strike == 0 && ball == 0) {
            sb.append("볼넷");
        } else if (strike == 0 && ball != 0) {
            sb.append(ball).append("볼");
        } else if (strike != 0 && strike != 3 && ball == 0) {
            sb.append(strike).append("스트라이크");
        } else if (strike == 3) {
            sb.append("3 스트라이크 아웃");
        }
        return sb;
    }

    public static boolean askReplay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        boolean replay = true;
        int number = sc.nextInt();
        if (number == 2) {
            replay = false;
        } else if (number == 1) {
            replay = true;
        }

        return replay;
    }

}
