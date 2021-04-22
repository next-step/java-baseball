package baseball;

import baseball.controller.GameController;

public class BaseballApplication {
    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ApplicationContext();
        final GameController gameController = applicationContext.getGameController();
        gameController.start();
    }
}
