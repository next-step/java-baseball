package baseball;

import baseball.controller.BaseBallGameController;

public class BaseBallGameApplication {

    public static void main(String[] args) {
        BaseBallGameController baseballGame = new BaseBallGameController();
        baseballGame.gameStart();
    }

}
