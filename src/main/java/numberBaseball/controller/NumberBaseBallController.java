package numberBaseball.controller;

import numberBaseball.dto.ResultResponse;
import numberBaseball.service.NumberBaseBallService;
import numberBaseball.view.ConsoleInput;
import numberBaseball.view.ConsoleOutput;

public class NumberBaseBallController {
    public static final String PARAMETER_TO_REPLAY = "1";
    public static final String PARAMETER_TO_EXIT = "2";
    NumberBaseBallService numberBaseBallService;

    public NumberBaseBallController(NumberBaseBallService numberBaseBallService) {
        this.numberBaseBallService = numberBaseBallService;
    }

    public void run() {
        boolean wantToReplay = false;
        do {
            playOneGame();
            wantToReplay = askToReplay();
        } while (wantToReplay);
    }

    private boolean askToReplay() {
        String wantToReplayInput = ConsoleInput.inputReplay();
        if (wantToReplayInput.equals(PARAMETER_TO_REPLAY)) {
            return true;
        }
        if (wantToReplayInput.equals(PARAMETER_TO_EXIT)) {
            return false;
        }
        throw new IllegalArgumentException();
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
