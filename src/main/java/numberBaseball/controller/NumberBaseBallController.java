package numberBaseball.controller;

import numberBaseball.dto.ResultResponse;
import numberBaseball.service.NumberBaseBallService;
import numberBaseball.view.ConsoleInput;
import numberBaseball.view.ConsoleOutput;

public class NumberBaseBallController {
    NumberBaseBallService numberBaseBallService;

    public NumberBaseBallController(NumberBaseBallService numberBaseBallService) {
        this.numberBaseBallService = numberBaseBallService;
    }

    public void run() {
        playOneGame();
    }

    private void playOneGame() {
        numberBaseBallService.generateTargetNumber();
        boolean isClear = false;
        while (!isClear) {
            String inputGameNumber = ConsoleInput.inputGameNumber();
            ResultResponse resultResponse = numberBaseBallService.getResultResponse(inputGameNumber);
            ConsoleOutput.printResult(resultResponse.getResult());
            isClear = resultResponse.isClear();
        }
        ConsoleOutput.printClearMessage();
    }
}
