package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.EndType;
import baseball.generator.AnswerGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {
    private final InputView inputView;
    private final ResultView resultView;

    public BaseballController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        Computer computer = Computer.from(new AnswerGenerator());
        while (!computer.isAllStrike()) {
            computer.play(inputView.inputNumbers());
            resultView.printScore(computer);
        }
        resultView.printEndMessage();
        chooseEndType(inputView.inputChooseType());
    }

    private void chooseEndType(final String type) {
        EndType endType = EndType.findEndType(type);
        if (endType.equals(EndType.SYSTEM_EXIT)) {
            System.exit(0);
        }
        run();
    }
}
