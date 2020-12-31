public class BallCount {

    private int strike;
    private int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {

        if(strike==0&&ball==0){
            return "낫싱";
        }
        return (strike!=0?this.strike+" 스트라이크 ":"")+(ball!=0?this.ball+" 볼":"");
    }

}
