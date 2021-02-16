package controller;

import domain.Computer;
import domain.Game;
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
        Game game = new Game();
        while (game.isRunning()) {
            gameInit();
            gameStart();
        }
    }

    private void gameInit() {
        Computer computer = new Computer();
    }

    public void gameStart() {
        inputView.getUserNumbers();
    }
}
