package domain;

public class BallCount {

    private int strikes;
    private int balls;

    public BallCount() {
        this.strikes = 0;
        this.balls = 0;
    }

    public BallCount(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public void resetCount() {
        this.strikes = 0;
        this.balls = 0;
    }

    public void isStrike(Number answerNumber, Number guessNumber) {
        if (answerNumber.equals(guessNumber)) {
            this.strikes++;
        }
    }

    public void isBall(BallNumbers ballNumbers, Number answerNumber, Number guessNumber) {
        if (!answerNumber.equals(guessNumber) && ballNumbers.contains(guessNumber)) {
            this.balls++;
        }
    }

    public boolean isDone(int DONE) {
        return strikes == DONE;
    }

    private boolean isNothing() {
        return this.strikes == 0 && this.balls == 0;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return Result.NOTHING.getMessage();
        }
        return (Result.BALL.getResult(this.balls)
                + " "
                + Result.STRIKE.getResult(this.strikes)).trim();
    }
}
