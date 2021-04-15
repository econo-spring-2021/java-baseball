import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean retry  = true;

        do {
            Game game = new Game();
            game.play(scanner);
            retry = askRetry(scanner);
        } while (retry);
    }

    public static boolean askRetry(Scanner scanner) {
        System.out.println(Constants.MESSAGE_COMMAND_RESTART_OR_END);
        int retry = scanner.nextInt();
        if(retry == 1) {
            return true;
        } else {
            return false;
        }
    }
}
