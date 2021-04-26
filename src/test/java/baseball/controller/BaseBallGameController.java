package baseball.controller;

import baseball.service.InputSupplier;
import baseball.service.ResultChecker;
import baseball.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameController {
    private ResultChecker checker;

    public BaseBallGameController() {
        this.checker = new ResultChecker();
    }

    public void gameStart() {
        while (ResultChecker.gameStatus != GameStatus.EXIT) {
            ResultChecker.gameStatus.printMessage();

            String userInput = InputSupplier.getInput();
            List<Integer> userNumbers = this.getUserNumbers(userInput);
            checker.notifyMatchResult(userNumbers);
            checker.checkAllMatches();
        }
    }

    public List<Integer> getUserNumbers(String userInput) {
        // TODO : 사용자가 중복되는 숫자를 입력 못하게 막아야 함.
        // TODO : 반드시 세자리 숫자를 입력받도록 체크 해야함
        List<Integer> userNumbers = new ArrayList<>();
        for (String strNum : userInput.trim().split("")) {
            userNumbers.add(Integer.parseInt(strNum));
        }

        return userNumbers;
    }
}
