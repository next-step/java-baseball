package game;

import game.controller.BaseballController;
import game.view.InputView;
import game.view.ResultView;

public class BaseballApplication {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(inputView, resultView);
        baseballController.startGame();
    }
}
