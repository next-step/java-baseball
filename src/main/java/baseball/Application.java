package baseball;

import baseball.context.ApplicationContext;
import baseball.domain.BaseBallGame;
import baseball.ui.GameController;

public class Application {
    public static void main(String[] args) {
        GameController controller = ApplicationContext.getGameController();

        run(controller);
    }

    private static void run(GameController controller) {
        do {
            doGame(controller);
        } while (controller.willRestartGame());
    }

    private static void doGame(GameController controller) {
        BaseBallGame game = controller.startGame();
        while (!game.isEnd()) {
            controller.guess(game);
        }
    }
}
