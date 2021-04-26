package baseball.controller;

import baseball.entity.Computer;
import baseball.entity.SelectNumberGenerator;
import baseball.model.CompareResult;
import baseball.util.ValidateNumberUtil;
import baseball.view.InputView;
import baseball.view.ResultView;

import static baseball.util.ValidateNumberUtil.NUMBER_LENGTH;

public class BaseballController {

    private static final int GAME_RESTART_OPTION = 1;
    private static final int GAME_END_OPTION = 2;

    public static void start() {

        int continueOption = GAME_RESTART_OPTION;

        while (continueOption == GAME_RESTART_OPTION) {

            SelectNumberGenerator selectNumber = new SelectNumberGenerator();

            baseballGame(new Computer(selectNumber.generateNumber()));

            continueOption = baseballGameContinueOption();
        }
    }

    private static void baseballGame(Computer computer) {
        String inputNumber = InputView.gameNumberInput();

        if (ValidateNumberUtil.validateNumber(inputNumber)) {
            ResultView.invalidNumberMessage();
            baseballGame(computer);
            return;
        }

        CompareResult compareResult = computer.compareNumber(inputNumber);

        if (compareResult.strikeCount() == NUMBER_LENGTH) {
            ResultView.allStrikePrint();
            return;
        }

        ResultView.resultPrint(compareResult);

        baseballGame(computer);
    }

    private static int baseballGameContinueOption() {
        int continueOption = InputView.restartInput();

        if ((continueOption == GAME_RESTART_OPTION) || (continueOption == GAME_END_OPTION)) {
            return continueOption;
        }

        return baseballGameContinueOption();
    }

}
