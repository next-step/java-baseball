package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.SelectNumberGenerator;
import baseball.model.CompareResult;
import baseball.util.ValidateNumberUtil;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballController {
    private final static SelectNumberGenerator selectNumber = new SelectNumberGenerator();
    private final static Computer computer = new Computer(selectNumber.generateNumber());

    public static void start() {
        baseballGame();
    }

    private static void baseballGame(){
        String inputNumber = InputView.gameNumberInput();

        if (ValidateNumberUtil.validateNumber(inputNumber)) {
            ResultView.invalidNumberMessage();
            baseballGame();
        }

        CompareResult compareResult = computer.compareNumber(inputNumber);
        ResultView.resultPrint(compareResult);

        if (compareResult.strikeCount() == 3) {
            return;
        }

        baseballGame();
    }

}
