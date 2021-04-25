package controller;

import domain.BaseballGame;
import domain.GameNumberGenerator;
import domain.Numbers;
import domain.Results;
import view.InputView;
import view.PrintView;

public class Controller {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new GameNumberGenerator());
        InputView inputView = new InputView();
        PrintView printView = new PrintView();

        while (!game.isOver()) {
            inputView.inputNumbers();
            Results results = game.start(Numbers.of(inputView.getNumbers()));

            printView.printResult(results.createResultMessage());
            continueOrInputNextAction(game, inputView);
        }
    }

    private static void continueOrInputNextAction(BaseballGame game, InputView inputView) {
        if (game.isClear()) {
            inputView.inputContinueNumber();
        }
    }
}
