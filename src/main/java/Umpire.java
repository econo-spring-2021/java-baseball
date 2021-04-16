import java.util.List;

public final class Umpire {
    public static Score judgeRoundScore(List<Ball> winningBall, List<Ball> playerBall, int numOfUsedBall) {
        Score score = new Score();

        for (int i = 0; i < numOfUsedBall; i++) {
            if (winningBall.get(i).equals(playerBall.get(i))) {
                score.plusStrikeCnt();
            } else if (playerBall.contains(winningBall.get(i))) {
                score.plusBallCnt();
            }
        }

        return score;
    }

    public static int judgeRoundWinning(Score score, int numOfUsedBall) {
        if (score.getStrikeCnt() == numOfUsedBall) {
            return Round.ROUND_WIN;
        } else if (score.getStrikeCnt() == 0 && score.getBallCnt() == 0) {
            return Round.ROUND_FAIL_FOUR_BALL;
        } else if (score.getStrikeCnt() == 0 && score.getBallCnt() > 0) {
            return Round.ROUND_FAIL_ONLY_BALL;
        } else if (score.getStrikeCnt() > 0 && score.getBallCnt() == 0) {
            return Round.ROUND_FAIL_ONLY_STRIKE;
        } else if (score.getStrikeCnt() > 0 && score.getBallCnt() > 0) {
            return Round.ROUND_FAIL_STRIKE_AND_BALL;
        }
        return Round.ERROR;
    }

}
