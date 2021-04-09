package baseballGame;

public class Main {

    public static boolean askRetry() {
        return false;
    }

    public static void playGame() {
    }

    public static void main(String[] args) {
        boolean willRetry;
        do {
            playGame();

            willRetry = askRetry();
        } while (willRetry);
    }
}
