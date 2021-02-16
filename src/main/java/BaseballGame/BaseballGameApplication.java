package BaseballGame;

import BaseballGame.controller.BaseballGameController;

public class BaseballGameApplication {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController();
        baseballGameController.playOneInning();
    }
}
