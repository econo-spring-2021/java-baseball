public class OutputView {
    public void printResultMeesage(int flag, Score score) {
        switch(flag) {
            case Round.ROUND_WIN:
                System.out.println(Message.WINNING_MESSAGE);
                break;
            case Round.ROUND_FAIL_STRIKE_AND_BALL:
                System.out.println(Message.STRIKE + score.getStrikeCnt() + " " + Message.BALL + score.getBallCnt());
                break;
            case Round.ROUND_FAIL_ONLY_STRIKE:
                System.out.println(Message.STRIKE + score.getStrikeCnt());
                break;
            case Round.ROUND_FAIL_ONLY_BALL:
                System.out.println(Message.BALL + score.getBallCnt());
                break;
            case Round.ROUND_FAIL_FOUR_BALL:
                System.out.println(Message.FOUR_BALL);
                break;
        }
    }

    public void printOutOfTrialMessage() {
        System.out.println(Message.OUT_OF_TRIAL);
    }
}
