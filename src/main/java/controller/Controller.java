package controller;

import domain.Game;
import domain.Number;
import view.Input;
import view.Output;

public class Controller {
    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        do {
            playOneGame();
        } while (input.getNextGame());
    }

    public void playOneGame() {
        Game game = new Game();
        while (!game.isFinished()) {
            output.printResultData(
                game.doTurn(Number.createByInput(input.getNumber()))
            );
        }
        output.printGameEndMessage();
    }
}
