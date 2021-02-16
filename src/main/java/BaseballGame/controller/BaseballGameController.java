package BaseballGame.controller;

import BaseballGame.domain.BaseballGame;
import BaseballGame.view.InputView;
import BaseballGame.view.OutputView;

public class BaseballGameController {
    private static BaseballGame baseballGame = new BaseballGame();

    public void playBaseballGame() {
        boolean reGame = true;
        while (reGame) {
            playOneGame();
            reGame = InputView.askRegame();
            baseballGame = new BaseballGame();
        }
    }

    public void playOneGame() {
        boolean isCorrect = false;
        while (!isCorrect) {
            int tryNumber = InputView.inputTryNumber(baseballGame.getNextInningCount());
            isCorrect = baseballGame.playInning(tryNumber);
            OutputView.printInningResult(baseballGame.getLastResult());
        }
        OutputView.printCorrectMessage();
    }
}
