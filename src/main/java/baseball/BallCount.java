package baseball;

public class BallCount {

    public static final int BALL_COUNT_SIZE = 3;

    private int strike;
    private int ball;

    public BallCount(){
        this.strike = 0;
        this.ball = 0;
    }

    public BallCount(final int strike, final int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isNoting(){
        return strike == 0 && ball == 0 ? true : false;
    }

    public boolean isEndGame(){
        return strike == 3 ? true : false;
    }

    public void addStrike(){
        this.strike++;
    }

    public void addBall(){
        this.ball++;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append(strike)
                .append("S")
                .append(ball)
                .append("B")
                .toString();
    }
}
