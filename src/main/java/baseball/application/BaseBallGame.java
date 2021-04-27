package baseball.application;

import baseball.enums.GameStatus;
import baseball.service.InputSupplier;
import baseball.service.ResultChecker;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private ResultChecker checker;

    public BaseBallGame() {
        this.checker = new ResultChecker();
    }

    public void gameStart() {
        while (ResultChecker.gameStatus != GameStatus.EXIT) {
            ResultChecker.gameStatus.printMessage();

            String userInput = InputSupplier.getInput();
            List<Integer> userNumbers = this.getNumbersByUser(userInput);
            checker.showMatchCount(userNumbers);
            checker.checkAllMatches();
        }
    }

    public List<Integer> getNumbersByUser(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (String strNum : userInput.trim().split("")) {
            userNumbers.add(Integer.parseInt(strNum));
        }

        return userNumbers;
    }
}
