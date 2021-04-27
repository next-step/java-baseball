package controller;

import domain.Player;
import domain.Result;
import view.InputView;
import view.ResultView;

public class BaseballGame {
    InputView inputView;
    ResultView resultView;

    public BaseballGame() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        boolean isContinue = true;

        Result result = new Result();
        Player computher = new Player();
        while (isContinue) {
            int number = inputView.inputNumber();

            Player user = new Player(number);

            computher.match(user, result);

            resultView.displayResult(result.toString());

            if (result.isGameClear()) {
                int stringContinue = inputView.inputContinue();
                isContinue = (stringContinue == 1);
                computher.reset(isContinue);
            }

            result.resetCount();
        }
    }
}
