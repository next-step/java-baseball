package BaseballGame.controller;

import BaseballGame.domain.BaseballGame;
import BaseballGame.view.InputView;
import BaseballGame.view.OutputView;

public class BaseballGameController {
    private static final BaseballGame baseballGame = new BaseballGame();

    public void playOneInning() {
        int tryNumber = InputView.inputTryNumber(1);
        baseballGame.playInning(tryNumber);
        OutputView.printInningResult(baseballGame.getLastResult());
    }
}
