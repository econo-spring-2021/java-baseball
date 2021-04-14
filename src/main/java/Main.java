import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;


public class Main {
    static int[] computer_select; // 컴퓨터가 선택한 숫자
    static int[] user_select; // 사용자가 선택한 숫자
    static boolean[] computer_check; // 컴퓨터가 어떤 숫자 선택했는지 알기 위한 배열
    static boolean[] user_check; // 사용자가 어떤 숫자 선택했는지 알기 위한 배열 배열
    static int strike_cnt; // 스트라이크 개수
    static int game_cnt=0; // 실행한 게임 횟수


    static boolean init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option;
        do {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ");
            option = Integer.parseInt(br.readLine());
        }while(option !=1 && option !=2);
        input_computer();
        game_cnt=0;
        strike_cnt=0;
        return option == 1;
    }

    static void input_computer(){
        HashSet<Integer> numbers = new HashSet<>();
        Random random = new Random();
        while(numbers.size()<3){
            numbers.add(random.nextInt(9)+1);
        }
        computer_select = new int[3];
        computer_check = new boolean[10];
        Iterator itr = numbers.iterator();
        int i=0;
        while(itr.hasNext()){
            int num = (int)itr.next();
            computer_select[i++] = num;
            computer_check[num] = true;
        }
    }

    static void input_user() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        user_select = new int[3];
        user_check = new boolean[10];
        String str= br.readLine();
        String[] strings = str.split("");
        for (int i=0; i<user_select.length; i++){
            int num = Integer.parseInt(strings[i]);
            user_select[i]= num;
            user_check[num] = true;
        }
    }

    static boolean ball_check (boolean[] computer, boolean[] user){
        for (int i=0; i< computer_check.length; i++){
            if(computer_check[i] && user_check[i])
                return true;
        }
        return false;
    }

    static void strike_count (int[]computer, int[] user){
       strike_cnt =0;
       for (int i=0; i<computer.length; i++) {
           if (computer[i] == user[i])
               strike_cnt++;
       }

    }

    static int ball_count (int[] computer,int[] user){
        int ball_cnt=0;
        for (int i=0; i<computer_check.length; i++){
            if(computer_check[i] && user_check[i])
                ball_cnt++;
        }
        ball_cnt -= strike_cnt;
        return ball_cnt;
    }

    static void play() throws IOException {
        System.out.print(++game_cnt+"번째 숫자를 입력해주세요 : ");
        input_user(); // 사용자 입력
        boolean ball_flag = ball_check(computer_check, user_check);
        strike_count(computer_select, user_select);
        int ball_cnt = ball_count(computer_select, user_select);

       if(ball_flag && ball_cnt<=0 && strike_cnt<3){
           System.out.println(strike_cnt +" 스트라이크");
       }
       else if(strike_cnt>0 && ball_cnt>0){
           System.out.println(strike_cnt +"스트라이크 " +ball_cnt+" 볼");
       }
       else if(strike_cnt == 0 && ball_cnt>0) {
           System.out.println(ball_cnt + " 볼");
       }
       else if(strike_cnt>=3){
           System.out.println("3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.");
       }
       else{
            System.out.println("볼넷");
        }

       if(strike_cnt<3 && game_cnt >=9){
            System.out.println("9번의 시도 동안 맞히지 못했습니다! 당신의 패배입니다.");
        }

    }

    public static void main(String[] args) throws IOException {
        input_computer();
        for (int i=0; i< computer_select.length; i++){
            System.out.print(computer_select[i]+" ");
        }
        boolean start = true;
        do{
            play();
            if(game_cnt>=9) start =init();
            if(strike_cnt >=3) start = init();
        }
        while (start);
    }
}
