package controller;

import domain.BaseballGame;
import domain.GameNumberGenerator;
import domain.Numbers;
import domain.Results;
import view.InputView;
import view.PrintView;

public class Controller {

    private static final String NEW_GAME_NUMBER = "1";
    private static final String GAME_OVER_NUMBER = "2";

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
            newGameOrGameOver(game, inputView.getContinueNumber());
        }
    }

    private static void newGameOrGameOver(BaseballGame game, String continueNumber) {
        if (continueNumber.equals(NEW_GAME_NUMBER)) {
            game.reset();
        }

        if (continueNumber.equals(GAME_OVER_NUMBER)) {
            game.over();
        }
    }
}
