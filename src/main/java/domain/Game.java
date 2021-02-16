package domain;

import dto.ResultData;

public class Game {
    private Number answer;
    private boolean isFinished;

    public Game() {
        this.answer = Number.createByRandom();
        this.isFinished = false;
    }

    public Game(Number answer) {
        this.answer = answer;
        this.isFinished = false;
    }

    public Game(boolean isFinished) {
        this.answer = Number.createByRandom();
        this.isFinished = false;
    }

    public Game(Number answer, boolean isFinished) {
        this.answer = answer;
        this.isFinished = isFinished;
    }

    public ResultData doTurn(Number candidate) {
        int strike = answer.getStrike(candidate);
        int ball = answer.getBall(candidate);

        Result turnResult = Result.of(strike, ball);
        if (turnResult == Result.OUT) {
            isFinished = true;
        }

        return new ResultData(
            turnResult.format(strike, ball)
        );
    }

    public boolean isFinished() {
        return isFinished;
    }
}
