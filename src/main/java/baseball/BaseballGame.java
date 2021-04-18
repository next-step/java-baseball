package baseball;

import view.ErrorMessage;
import view.Input;
import view.Output;
import java.util.List;

public class BaseballGame {
    public void gameStart() {
        Boolean success;
        String inputNum;
        List<Integer> randomNumberList = makeRandomNumberList();
        ErrorMessage errorMessage = new ErrorMessage();

        while (true) {
            inputNum = inputNum();
            if (!checkInputNumValid(inputNum)) {
                errorMessage.inputNumValidError();
                continue;
            }
            success = checkSuccess(randomNumberList, inputNum);
            if (!success) {
                continue;
            }
            if (!checkRestart()) {
                break;
            } else {
                randomNumberList = makeRandomNumberList();
            }
        }
    }

    private List<Integer> makeRandomNumberList() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return randomNumberGenerator.makeRandomNumberList();
    }

    private String inputNum() {
        Input input = new Input();
        return input.startGame();
    }

    private Boolean checkInputNumValid(String inputNum) {
        CheckInputNumValidation checkInputNumValidation = new CheckInputNumValidation();
        return checkInputNumValidation.isValid(inputNum);
    }

    private Boolean checkSuccess(List<Integer> randomNumberList, String inputNum) {
        CheckResult checkResult = new CheckResult();
        return checkResult.getResult(randomNumberList, inputNum);
    }

    private Boolean checkRestart() {
        ErrorMessage errorMessage = new ErrorMessage();

        Output output = new Output();
        String restartNum;
        while (true) {
            restartNum = output.reStart();
            if (restartNum.equals("1")) {
                return true;
            } else if (restartNum.equals("2")) {
                break;
            } else {
                errorMessage.checkRestartNumError();
            }
        }
        return false;
    }

}

