package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.SelectNumberGenerator;
import baseball.util.ValidateNumberUtil;
import baseball.view.InputView;

public class BaseballController {
    public static void start() {
        SelectNumberGenerator selectNumber = new SelectNumberGenerator();

        Computer computer = new Computer(selectNumber.generateNumber());

        String inputNumber = InputView.gameNumberInput();

        ValidateNumberUtil.validateNumber(inputNumber);



    }
}
