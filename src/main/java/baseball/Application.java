package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.NumberGenerateStrategy;
import baseball.domain.Opponent;
import baseball.domain.RandomBallNumbersGenerator;
import baseball.ui.GameController;
import baseball.ui.InputView;
import baseball.ui.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application application = Application.initialize();
        application.run();
    }

    private final Opponent opponent;
    private final NumberGenerateStrategy numberGenerateStrategy;
    private final GameController gameController;

    private Application(
            Opponent opponent,
            NumberGenerateStrategy numberGenerateStrategy,
            GameController gameController
    ) {
        this.opponent = opponent;
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.gameController = gameController;
    }


    public static Application initialize() {
        RandomBallNumbersGenerator numberGenerateStrategy = new RandomBallNumbersGenerator();
        Opponent opponent = new Opponent(numberGenerateStrategy);

        return new Application(
                opponent,
                numberGenerateStrategy,
                new GameController(new InputView(new Scanner(System.in)), new OutputView(), opponent)
        );
    }

    public void run() {
        do {
            doGame();
        } while (gameController.willRestartGame());
    }

    private void doGame() {
        BaseBallGame game = gameController.startGame();
        while (!game.isEnd()) {
            gameController.guess(game);
        }
    }
}
