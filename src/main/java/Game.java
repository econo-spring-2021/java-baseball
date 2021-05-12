import java.util.ArrayList;
import java.util.List;

public class Game {
    public final static int TRIAL_NUMBER = 9;
    public final static int NUMBER_OF_USED_BALL = 3;

    private boolean STATUS;
    private boolean OUT_OF_TRIAL;
    private List<Ball> winningBall = new ArrayList<>();
    private List<Round> round = new ArrayList<>();

    public Game() {
        STATUS = true;
        OUT_OF_TRIAL = false;
        randomPick(NUMBER_OF_USED_BALL);
    }

    public boolean getStatus() {
        return STATUS;
    }

    public boolean isOutOfTrial() {
        return OUT_OF_TRIAL;
    }

    public int nextRound(String inputValue) {
        List<Ball> playerBall = new ArrayList<>(convertToBall(inputValue));

        Round newRound = new Round(winningBall, playerBall);
        int resultFlag = newRound.getResult();
        round.add(newRound);

        if (round.size() == TRIAL_NUMBER) {
            STATUS = false;
            OUT_OF_TRIAL = true;
        }
        if (resultFlag == Round.ROUND_WIN) {
            STATUS = false;
        }

        return resultFlag;
    }

    public Score getCurrentRoundScore() {
        return round.get(round.size()-1).getScore();
    }

    private void randomPick(int cnt) {
        while(winningBall.size() < cnt) {
            Ball pickedBall = new Ball((int)(Math.random() * 9) + 1);
            if (!winningBall.contains(pickedBall)) winningBall.add(pickedBall);
        }
    }

    private List<Ball> convertToBall(String inputValue) {
        List<Ball> playerBall = new ArrayList<>(NUMBER_OF_USED_BALL);

        for (int i = 0; i < NUMBER_OF_USED_BALL; i++) {
            playerBall.add(new Ball(Character.getNumericValue(inputValue.charAt(i))));
        }

        return playerBall;
    }
}