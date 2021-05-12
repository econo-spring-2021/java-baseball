import java.util.Scanner;

public class InputView {
    public String inputPlayerBall(Scanner scanner) {
        System.out.print(Message.INPUT_PLAYER_BALL);
        return scanner.nextLine();
    }

    public int inputRetryFlag(Scanner scanner) {
        System.out.println(Message.ASK_RETRY);
        return Integer.parseInt(scanner.nextLine());
    }
}
