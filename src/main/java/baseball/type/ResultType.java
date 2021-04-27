package baseball.type;

public class ResultType {
    private int strikeCnt;
    private int ballCnt;

    public ResultType() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void strikePlus() {
        this.strikeCnt++;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void ballPlus() {
        this.ballCnt++;
    }

    public boolean isResult() {
        return strikeCnt == 3;
    }
}
