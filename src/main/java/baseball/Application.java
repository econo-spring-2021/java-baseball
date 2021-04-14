package baseball;

public class Application {
    public static void main(String[] args){
        int re;

        do{
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
        }while(re == 1);
    }
}
