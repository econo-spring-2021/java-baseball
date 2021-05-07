public class OutputView {
    public void showOnlyBallResult(BaseballScore baseballScore) {
        System.out.println(String.format(Constants.MESSAGE_BALL, baseballScore.ball));
    }

    public void showOnlyStrikeResult(BaseballScore baseballScore) {
        System.out.println(String.format(Constants.MESSAGE_STRIKE, baseballScore.strike));
    }

    public void showStrikeAndBallResult(BaseballScore baseballScore) {
        System.out.println(String.format(Constants.MESSAGE_STRIKE + " " + Constants.MESSAGE_BALL, baseballScore.strike, baseballScore.ball));
    }

    public void showFourBallResult() {
        System.out.println("볼넷");
    }

    public void showFailureMessage() {
        System.out.println(Constants.MESSAGE_FAILURE);
    }

    public void showVictoryMessage() {
        System.out.println(Constants.MESSAGE_VICTORY);
    }
}
