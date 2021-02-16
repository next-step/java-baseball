package BaseballGame.controller;

import BaseballGame.domain.BaseballGame;
import BaseballGame.view.InputView;
import BaseballGame.view.OutputView;

public class BaseballGameController {
    private static BaseballGame baseballGame = new BaseballGame();

    public void playBaseballGame() {
        while (true) {
            playOneGame();
            if (!InputView.askRegame()) {
                break;
            } else {
                baseballGame = new BaseballGame();
            }
        }
    }

    public void playOneGame() {
        while (true) {
            int tryNumber = InputView.inputTryNumber(baseballGame.getNextInningCount());
            boolean isCorrect = baseballGame.playInning(tryNumber);
            if (isCorrect) {
                OutputView.printCorrectMessage();
                break;
            }
            OutputView.printInningResult(baseballGame.getLastResult());
        }
    }
}
