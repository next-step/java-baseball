package controller;

import domain.BaseballGame;
import domain.GameNumberGenerator;
import domain.Results;
import utils.NumberUtils;
import view.InputView;
import view.PrintView;

public class Controller {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new GameNumberGenerator());
        InputView inputView = new InputView();
        PrintView printView = new PrintView();

        while (!game.isOver()) {
            inputView.inputNumbers();
            Results results = game.start(NumberUtils.toList(inputView.getNumbers()));

            printView.printResult(results.createResultMessage());
            continueOrInputCommand(game, inputView);
        }
    }

    private static void continueOrInputCommand(BaseballGame game, InputView inputView) {
        if (game.isClear()) {
            inputView.inputContinueNumber();
            game.executeCommand(inputView.getContinueNumber());
        }
    }
}
