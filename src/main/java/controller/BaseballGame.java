package controller;

import domain.BaseballStatus;
import domain.BaseballNumberBundle;
import domain.Computer;
import domain.Player;
import view.InputView;
import view.OutputView;

public class BaseballGame {
    public void start() {
        do {
            oneGame();
        } while(InputView.getReStartInput());
    }

    private void oneGame() {
        Player computer = new Computer();
        BaseballStatus status;
        do {
            BaseballNumberBundle userExpectedBaseballNumber = new BaseballNumberBundle(InputView.getUserBaseBallInput());
            status = computer.getBaseballNumberBundle().getCompareResult(userExpectedBaseballNumber);
            OutputView.printResult(status.toString());
        } while (!jackpotCheck(status));
    }

    private boolean jackpotCheck(BaseballStatus status) {
        boolean jackpot = status.isJackpot();
        if (jackpot) {
            OutputView.printJackpot();
        }
        return jackpot;
    }


}
