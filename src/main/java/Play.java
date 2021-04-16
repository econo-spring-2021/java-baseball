import java.util.Scanner;

public class Play {
    boolean PLAY_FLAG;
    Scanner scanner;
    InputView inputView;
    Game game;
    OutputView outputView;

    public Play() {
        PLAY_FLAG = true;
        scanner = new Scanner(System.in);
        inputView = new InputView();
        game = null;
        outputView = new OutputView();
    }

    public void play() {
        game = new Game();

        while (game.getStatus()) {
            String playerInput = inputView.inputPlayerBall(scanner);
            int result = game.nextRound(playerInput);
            outputView.printResultMeesage(result, game.getCurrentRoundScore());
        }

        if (game.isOutOfTrial()) {
            outputView.printOutOfTrialMessage();
        }

        askReplay();
    }

    private void askReplay() {
        if (game == null) return;
        int flag = inputView.inputRetryFlag(scanner);
        if (flag == 2) PLAY_FLAG = false;
    }
}
