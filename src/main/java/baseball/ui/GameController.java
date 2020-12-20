package baseball.ui;

import baseball.domain.BallNumbers;
import baseball.domain.BaseBallGame;
import baseball.domain.GameResult;
import baseball.domain.Opponent;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Opponent opponent;

    public GameController(InputView inputView, OutputView outputView, Opponent opponent) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.opponent = opponent;
    }

    public BaseBallGame startGame() {
        return BaseBallGame.initialize(opponent);
    }

    public void guess(BaseBallGame game) {
        GameResult result = game.guess(BallNumbers.from(inputView.enterBallNumbers()));
        outputView.printResult(GameResultResponse.from(result));
    }

    public boolean willRestartGame() {
        return inputView.enterIfRestart()
                .isRestart();
    }
}
