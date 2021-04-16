import java.util.ArrayList;
import java.util.List;

public class Round {
    public final static int ROUND_WIN = 1;
    public final static int ERROR = 0;
    public final static int ROUND_FAIL_STRIKE_AND_BALL = -1;
    public final static int ROUND_FAIL_ONLY_STRIKE = -2;
    public final static int ROUND_FAIL_ONLY_BALL = -3;
    public final static int ROUND_FAIL_FOUR_BALL = -4;

    private List<Ball> playerBall;
    private Score score;
    private int result;

    public Round(List<Ball> winningBall, List<Ball> playerBall) {
        this.playerBall = new ArrayList<>(playerBall);
        this.score = Umpire.judgeRoundScore(winningBall, playerBall, Game.NUMBER_OF_USED_BALL);
        this.result = Umpire.judgeRoundWinning(this.score, Game.NUMBER_OF_USED_BALL);
    }

    public Score getScore() {
        return score;
    }

    public int getResult() {
        return result;
    }
}
