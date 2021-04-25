public class BaseballGameResult {

    private int strike;
    private int ball;

    public BaseballGameResult(){
        super();
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
        StringBuilder sb = new StringBuilder();
        sb.append(strike);
        sb.append(" 스트라이크 ");
        sb.append(ball);
        sb.append("볼");
        return sb.toString();
    }

    public boolean isNothing(){
        if(strike == 0 && ball == 0) return true;
        return false;
    }

    public boolean isFinish(){
        if(strike == 3) return true;
        return false;
    }
}
