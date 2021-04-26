import domain.BaseballNumberScore;
import domain.BaseballNumbers;
import domain.BaseballResult;
import view.ContinuePlay;
import domain.BaseballNumberGenerator;
import util.TransStringNumberToNumberListUtil;
import view.InputView;
import view.ResultView;

import java.util.List;

public class BaseballGame {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        new BaseballGame().gameStart();
    }

    private void gameStart() {
        boolean continueGame = true;
        while (continueGame) {
            BaseballNumberScore baseballNumberScore = new BaseballNumberScore(
                    BaseballNumbers.create(BaseballNumberGenerator.generator())
            );
            playRound(baseballNumberScore);

            continueGame = isContinuePlay();
        }
    }

    private boolean isContinuePlay() {
        ContinuePlay continuePlay = ContinuePlay.create(inputView.isContinue());
        return continuePlay.isContinuePlay();
    }

    private void playRound(BaseballNumberScore baseballNumberScore) {
        boolean gameover = false;

        while (!gameover) {
            BaseballResult baseballResult = baseballNumberScore.judge(getPlayerNumber());

            gameover = roundResult(baseballResult);
        }
        resultView.finishScreen();
    }

    private boolean roundResult(BaseballResult baseballResult) {
        resultView.showResult(baseballResult);
        return baseballResult.isEndGame();
    }

    private BaseballNumbers getPlayerNumber() {
        List<Integer> inputNumbers = TransStringNumberToNumberListUtil.toNumberList(inputView.inputNumber());
        return BaseballNumbers.create(inputNumbers);
    }
}
