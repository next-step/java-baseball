package baseball.domain;

import baseball.domain.enums.ScoreStatus;

import static baseball.domain.BaseballNumbers.RANDOM_NUMBER_COUNT;

public class Score {
    private ScoreStatus scoreStatus;
    private int strike;
    private int ball;

    public static Score measureScore(BaseballNumbers answer, BaseballNumbers playerInput) {
        Score result = new Score();

        for (int i = 0; i < RANDOM_NUMBER_COUNT; i++) {
            result.judgeBaseballNumber(answer, playerInput.getSpecificIndexValue(i), i);
        }

        result.scoreStatus = ScoreStatus.NORMAL;

        return result;
    }

    public ScoreStatus getScoreStatus() {
        return scoreStatus;
    }

    public boolean isPassed() {
        if(strike == RANDOM_NUMBER_COUNT) {
            return true;
        }

        return false;
    }

    public boolean hasStrike() {
        if(strike >= 1 && strike < RANDOM_NUMBER_COUNT) {
            return true;
        }

        return false;
    }

    public boolean hasBall() {
        if(ball >= 1) {
            return true;
        }

        return false;
    }

    public boolean isNothing() {
        if(strike == 0 && ball == 0) {
            return true;
        }

        return false;
    }

    public static Score createErrorStateScore() {
        Score score = new Score();
        score.scoreStatus = ScoreStatus.ERROR;

        return score;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    private void judgeBaseballNumber(BaseballNumbers answer, String partialPlayerInput, int playerInputIndex) {
        int judgementResult = answer.indexOf(partialPlayerInput);

        if (judgementResult == playerInputIndex) {
            plusStrikeCount();
        } else if (judgementResult > -1) {
            plusBallCount();
        }
    }

    private void plusStrikeCount() {
        this.strike++;
    }

    private void plusBallCount() {
        this.ball++;
    }
}
