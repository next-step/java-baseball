package kr.insup;

import kr.insup.controller.GameController;

public class GameApplication {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
