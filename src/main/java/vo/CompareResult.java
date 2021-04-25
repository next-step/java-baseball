package vo;

public class CompareResult {
    private int strikeCnt;
    private int ballCnt;

    public int getStrikeCnt() {
        return this.strikeCnt;
    }

    public void plusStrikeCnt() {
        this.strikeCnt++;
    }

    public void plusBallCnt() {
        this.ballCnt++;
    }

    public void print() {
        System.out.printf("strike : %d, ball : %d%n", this.strikeCnt, this.ballCnt);
    }
}
