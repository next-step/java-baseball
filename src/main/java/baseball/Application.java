package baseball;

import baseball.context.ApplicationContext;
import baseball.controller.GameController;
import baseball.domain.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        GameController controller = ApplicationContext.getGameController();
        do {
            doOneGame(controller);
        } while (controller.willRestartGame());
    }

    private static void doOneGame(GameController controller) {
        BaseBallGame game = controller.startGame();
        while (controller.isProceeding(game)) {
            controller.guess(game);
        }
    }
}
