public class Score {
    private int strikeCnt;
    private int ballCnt;

    public Score() {
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void plusStrikeCnt() {
        this.strikeCnt++;
    }

    public void plusBallCnt() {
        this.ballCnt++;
    }

    @Override
    public String toString() {
        return "Score{" +
                "strikeCnt=" + strikeCnt +
                ", ballCnt=" + ballCnt +
                '}';
    }
}
