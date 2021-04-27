package controller;

import domain.Balls;
import domain.Score;
import view.InputView;
import view.ResultView;

public class BaseballController {
    private InputView inputView;
    private ResultView resultView;
    private Balls randomBalls;

    public BaseballController() {
        inputView = new InputView();
        resultView = new ResultView();
        randomBalls = new Balls();
    }

    public void run() {
        boolean isFinish = false;

        while (!isFinish) {
            Balls inputBalls = inputView.balls();
            Score score = randomBalls.matchToScore(inputBalls);
            resultView.printScore(score);
            isFinish = isFinish(score);
        }
    }

    private boolean isFinish(Score score) {
        if (score.isFinish()) {
            resultView.printFinish();
            boolean isRestart = inputView.restart();
            reset(isRestart);
            return !isRestart;
        }
        return false;
    }

    private void reset(boolean isRestart) {
        if (isRestart) {
            randomBalls = new Balls();
        }
    }
}
