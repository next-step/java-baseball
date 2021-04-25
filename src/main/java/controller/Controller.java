package controller;

import domain.BaseballGame;
import domain.GameNumberGenerator;

public class Controller {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new GameNumberGenerator());
    }
}
