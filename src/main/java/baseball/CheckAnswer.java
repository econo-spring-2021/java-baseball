package baseball;

 class Data{
    int strike;
    int ball;
    int cnt = 0;
}
public class CheckAnswer {

    public static void check_list(int loop1, int loop2,int[] server, int[] client, Data data)
    {
        if (loop1 == loop2 && client[loop1] == server[loop2])
            data.strike++;
        else if (client[loop1] == server[loop2])
            data.ball++;
    }

    public static void check(int[] server, int[] client, Data data)
    {
        int i = 0;

        data.strike = 0;
        data.ball = 0;
        while(i < 3)
        {
            int j = 0;
            while(j < 3)
            {
                check_list(i, j, server, client, data);
                j++;
            }
            i++;
        }
    }
}
