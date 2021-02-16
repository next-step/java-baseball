package baseball;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballApplication {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final BaseballController baseballController = new BaseballController(inputView, outputView);
        baseballController.play();
    }
}