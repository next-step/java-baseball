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
        if (this.strikeCnt == 0 && this.ballCnt == 0) {
            System.out.println("nothing");
            return;
        }
        System.out.printf("strike : %d, ball : %d%n", this.strikeCnt, this.ballCnt);
    }
}
