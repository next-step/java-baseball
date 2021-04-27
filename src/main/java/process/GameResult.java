package process;

import logic.Answer;

public class GameResult {
    public static final int STRIKE = 1;
    public static final int BALL = 2;
    public static final int NOTHING = 3;
    private int strike;
    private int ball;

    public GameResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public void applyJudgment(int result) {
        if (result == STRIKE) {
            addStrike();
        }

        if (result == BALL) {
            addBall();
        }
    }

    public boolean isGameEnd() {
        return strike == Answer.ANSWER_SIZE && ball == 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }


    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
