package baseball;

import java.util.Scanner;

public class PrintResult {

    private static int checkFlag()
    {
        final Scanner scanner = new Scanner(System.in);
        int ret;

        do
        {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            ret = scanner.nextInt();
        } while (!(ret == 1 || ret == 2));
        return ret;
    }

    public static int printResult(Data data)
    {
        int re;

        data.cnt++;
        if(data.strike == 3)
        {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.");
            re = checkFlag();
            return re;
        }
        else if (data.strike == 0 && data.ball == 0)
            System.out.print("볼넷");
        else
        {
            if (data.ball != 0)
                System.out.print(data.ball + "볼 ");
            if (data.strike != 0)
                System.out.print(data.strike + "스트라이크");
            if (data.cnt == 3) {
                System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.");
                re = checkFlag();
                return re;
            }
        }
        return -1;
    }
}
