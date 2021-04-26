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
        boolean isEnd = false;

        while (!isEnd) {
            Balls inputBalls = inputView.balls();

            Score score = randomBalls.matchToScore(inputBalls);

            resultView.printScore(score);

            isEnd = restart(score);
        }
    }

    private boolean restart(Score score) {
        if (score.isFinish()) {

        }
        return false;
    }
}
