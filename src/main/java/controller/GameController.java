package controller;

import view.InputView;
import view.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        gameStart();
    }

    public void gameStart() {
        inputView.getUserNumbers();
    }
}
