package controller;

import domain.BaseballGame;
import domain.GameNumberGenerator;
import domain.Numbers;
import domain.Results;
import view.InputView;

public class Controller {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new GameNumberGenerator());
        InputView inputView = new InputView();

        while (!game.isOver()) {
            inputView.inputNumbers();
            Results results = game.start(Numbers.of(inputView.getNumbers()));
        }
    }
}
