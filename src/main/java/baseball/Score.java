package baseball;

public class Score {

    private int strike;
    private int ball;
    private String finalScore;

    public void init() {
        this.strike=0;
        this.ball=0;
    }

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public void addBall() {
        this.ball++;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }
    public String getFinalScore() {
        return finalScore;
    }

    public boolean judge() {
        if (isNothing()) {
            this.finalScore =  Message.NOTHING.getMessage();
            return false;
        }
        if (isAllStrike()) {
            this.finalScore =  Message.WIN.getMessage();
            return true;
        }
        this.finalScore =  isStrikeAndBall();
        return false;
    }

    public boolean isNothing() {
        if(this.strike == 0 && this.ball == 0) {
            return true;
        }
        return false;
    }

    public boolean isAllStrike() {
        if (this.strike == 3) {
            return true;
        }
        return false;
    }

    public String isStrikeAndBall() {
        String gameResult="";
        if (this.strike > 0) {
            gameResult += this.strike + " " + Message.STRIKE.getMessage();
        }
        if (this.ball > 0) {
            gameResult += this.ball + " " + Message.BALL.getMessage();
        }
        return gameResult;
    }
}
