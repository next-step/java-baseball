package game.controller;

import game.domain.Baseball;
import game.domain.RandomBall;
import game.domain.RenewAnswer;
import game.view.InputView;
import game.view.ResultView;

public class BaseballController {

    private final InputView inputView;
    private final ResultView resultView;
    private Baseball baseball;
    private final RandomBall randomBall = new RandomBall();
    private static final int STRIKE = 3;
    private RenewAnswer renewAnswer;

    public BaseballController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startGame() {
        do {
            calculate();
            renewAnswer = renewGame();
        } while (!renewAnswer.isExit());
    }

    private void requestInput() {
        try {
            String number = inputView.requestBallNumber();
            baseball = new Baseball(number);
        } catch (IllegalArgumentException e) {
            resultView.printErrorBaseballNum();
            requestInput();
        }
    }

    private void calculate() {
        do {
            requestInput();
            baseball.calculateBall(randomBall.getRandomBall());
            baseball.calculateStrikeBall(randomBall.getRandomBall());
            resultView.printResult(baseball.getStrikeCount(), baseball.getBallCount());
        } while (baseball.getStrikeCount() != STRIKE);
    }

    private RenewAnswer renewGame() {
        try {
            return renewAnswer = new RenewAnswer(inputView.requestRenewGame());
        } catch (IllegalArgumentException e) {
            resultView.printErrorAnswer();
            return renewGame();
        }
    }
}
