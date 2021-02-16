package baseball.controller;

import baseball.model.AnswerNumbers;
import baseball.model.InningResult;
import baseball.model.shot.Shots;
import baseball.model.strategy.AnswerStrategy;
import baseball.model.strategy.RandomStrategy;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    final InputView inputView;
    final OutputView outputView;

    public BaseballController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Shots shots = makeShots();
        while (true) {
            final String inputBaseballNumbers = inputView.inputBaseballNumbers();
            final InningResult inningResult = shots.makeResult(inputBaseballNumbers);

            outputView.printResult(inningResult.getMessage());
            if(inningResult.isFinish()) {
                if(inputView.inputFinishGame()) {
                    break;
                }
                shots = makeShots();
            }
        }
    }

    private Shots makeShots() {
        final AnswerStrategy answerStrategy = new RandomStrategy();
        final AnswerNumbers answerNumbers = new AnswerNumbers(answerStrategy);
        return new Shots(answerNumbers);
    }
}