package baseball.context;

import baseball.domain.NumberGenerateStrategy;
import baseball.domain.Opponent;
import baseball.domain.RandomBallNumbersGenerator;
import baseball.ui.GameController;
import baseball.ui.InputView;
import baseball.ui.OutputView;

import java.util.Scanner;

public class ApplicationContext {
    private static final ApplicationContext applicationContext;

    static {
        RandomBallNumbersGenerator numberGenerateStrategy = new RandomBallNumbersGenerator();
        Opponent opponent = new Opponent(numberGenerateStrategy);

        applicationContext = new ApplicationContext(
                opponent,
                numberGenerateStrategy,
                new GameController(new InputView(new Scanner(System.in)), new OutputView(), opponent)
        );
    }

    public static GameController getGameController() {
        return applicationContext.gameController;
    }

    private final Opponent opponent;
    private final NumberGenerateStrategy numberGenerateStrategy;
    private final GameController gameController;

    private ApplicationContext(
            Opponent opponent,
            NumberGenerateStrategy numberGenerateStrategy,
            GameController gameController
    ) {
        this.opponent = opponent;
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.gameController = gameController;
    }
}
