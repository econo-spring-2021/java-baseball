package baseballGame;

public class BallAvailability {
    private boolean isBoB;
    private int strikeCnt;
    private int ballCnt;

    public BallAvailability(boolean isBob) {
        this.isBoB = isBob;
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public BallAvailability(int strikeCnt, int ballCnt) {
        this.isBoB = false;
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public boolean getIsBob() {
        return isBoB;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }
}
