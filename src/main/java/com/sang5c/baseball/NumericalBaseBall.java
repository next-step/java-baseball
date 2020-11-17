package com.sang5c.baseball;

import com.sang5c.baseball.domain.Computer;
import com.sang5c.baseball.domain.Count;
import com.sang5c.baseball.domain.BaseBall;
import com.sang5c.baseball.ui.InputView;
import com.sang5c.baseball.ui.ResultView;

public class NumericalBaseBall {
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        String userContinueInput;
        do {
            BaseBall baseBall = Computer.randomNumbers();
            System.out.println("question : " + baseBall);

            startUserInteraction(baseBall);
            userContinueInput = InputView.getInputToContinue();
        } while (isNotExit(userContinueInput));
    }

    private static boolean isNotExit(String userContinueInput) {
        return !EXIT.equalsIgnoreCase(userContinueInput);
    }

    private static void startUserInteraction(BaseBall baseBall) {
        Count count;
        do {
            String userInput = InputView.getUserNumbersInput();
            BaseBall userBaseBall = BaseBall.of(userInput);

            count = baseBall.compare(userBaseBall);
            ResultView.printCount(count);
        } while (!count.isThreeStrike());
    }


}
