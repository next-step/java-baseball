package baseball.context;

import baseball.controller.GameController;
import baseball.domain.NumberGenerateStrategy;
import baseball.domain.RandomBallNumbersGenerator;
import baseball.ui.InputView;
import baseball.ui.OutputView;

import java.util.Scanner;

public class ApplicationContext {
    private static final ApplicationContext applicationContext;

    static {
        NumberGenerateStrategy numberGenerateStrategy = new RandomBallNumbersGenerator();
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        applicationContext = new ApplicationContext(new GameController(inputView, outputView, numberGenerateStrategy));
    }

    public static GameController getGameController() {
        return applicationContext.gameController;
    }

    private final GameController gameController;

    private ApplicationContext(GameController gameController) {
        this.gameController = gameController;
    }
}
