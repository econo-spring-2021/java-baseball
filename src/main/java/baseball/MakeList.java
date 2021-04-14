package baseball;

import java.util.Random;
import java.util.Scanner;

public class MakeList {

    public static int[] makeServerList()
    {
        int idx = 0;
        int []server = new int[3];
        int tmp;
        int []list = new int[10];
        Random random = new Random();

        while (idx != 3)
        {
            tmp = random.nextInt(9) + 1;
            if (list[tmp] == 0)
            {
                list[tmp] = 1;
                server[idx++] = tmp;
            }
        }
        System.out.println("서버: "+ server[0] + server[1] + server[2]);
        return server;
    }

    public static int[] makeClientList(Data data)
    {
        int idx = 3;
        int []client = new int[3];
        String tmp;
        final Scanner scanner = new Scanner(System.in);

        tmp = scanner.next();
        while (--idx >= 0)
        {
            if (tmp.charAt(idx) == '0' || tmp.length() != 3)
            {
                System.out.print("0 ~ 9사이 로 이뤄진 서로 다른 3개의 수를 입력하세요\n숫자를 입력해주세요: ");
                idx = 3;
                tmp = scanner.next();
                data.cnt++;
                continue;
            }
                client[idx] = tmp.charAt(idx) - '0';
        }
        return client;
    }
}
