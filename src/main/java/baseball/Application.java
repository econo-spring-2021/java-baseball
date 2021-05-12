package baseball;

public class Application {
    static int re;
    static void process()
    {
        int []server;
        int []client;
        Data data = new Data();

        server = MakeList.makeServerList();
        while(true)
        {
            System.out.print("숫자를 입력해주세요 : ");
            client = MakeList.makeClientList(data);
            CheckAnswer.check(server, client, data);
            re = PrintResult.printResult(data);
            if (re > 0)
                break;
            System.out.println();
        }
    }
    public static void main(String[] args){

        do{
            process();
        }while(re == 1);
    }
}
