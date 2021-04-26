package baseball.controller;

import baseball.domain.Computer;
import baseball.generator.AnswerGenerator;
import baseball.view.InputView;

public class BaseballController {
    private final InputView inputView;

    public BaseballController() {
        this.inputView = new InputView();
    }

    public void run() {
        Computer computer = Computer.from(new AnswerGenerator());

        while (!computer.isAllStrike()) {
            computer.play(inputView.inputNumbers());

        }
    }
}
