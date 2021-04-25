package controller;

import domain.BaseballGame;
import domain.GameNumberGenerator;
import view.InputView;

public class Controller {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new GameNumberGenerator());
        InputView inputView = new InputView();

        while (!baseballGame.isOver()) {
            inputView.inputNumbers();

        }
    }
}
