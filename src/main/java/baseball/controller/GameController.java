package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.domain.BaseBallNumbers;
import baseball.domain.GameResult;
import baseball.domain.NumberGenerateStrategy;
import baseball.ui.GameResultResponse;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerateStrategy numberGenerateStrategy;

    public GameController(InputView inputView, OutputView outputView, NumberGenerateStrategy numberGenerateStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public BaseBallGame startGame() {
        return BaseBallGame.initialize(numberGenerateStrategy);
    }

    public void guess(BaseBallGame game) {
        GameResult result = game.guess(BaseBallNumbers.from(inputView.enterBallNumbers()));
        outputView.printResult(GameResultResponse.from(result));
    }

    public boolean isProceeding(BaseBallGame game) {
        return !game.isEnd();
    }

    public boolean willRestartGame() {
        return inputView.enterIfRestart()
                .isRestart();
    }
}
