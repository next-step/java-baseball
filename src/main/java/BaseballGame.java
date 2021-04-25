import domain.BaseballNumberScore;
import domain.BaseballNumbers;
import domain.BaseballResult;
import util.BaseballNumberGenerator;
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
        boolean playingFlag = true;
        while (playingFlag) {
            BaseballNumberScore baseballNumberScore = new BaseballNumberScore(
                    BaseballNumbers.create(BaseballNumberGenerator.generator())
            );
            playRound(baseballNumberScore);

            playingFlag = isContinuePlay();
        }
    }

    private boolean isContinuePlay() {
        int continueAnswer = inputView.isContinue();
        if (continueAnswer == 1) {
            return true;
        }

        return false;
    }

    private void playRound(BaseballNumberScore baseballNumberScore) {
        boolean playBall = true;

        while (playBall) {
            List<Integer> inputNumbers = TransStringNumberToNumberListUtil.toNumberList(inputView.inputNumber());
            BaseballResult baseballResult = baseballNumberScore.judge(BaseballNumbers.create(inputNumbers));
            resultView.showResult(baseballResult);

            playBall = !baseballResult.isEndGame();
        }
        resultView.finishScreen();
    }
}
