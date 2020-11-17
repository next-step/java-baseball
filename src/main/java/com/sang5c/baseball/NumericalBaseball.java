package com.sang5c.baseball;

import com.sang5c.baseball.domain.Computer;
import com.sang5c.baseball.domain.BaseballCount;
import com.sang5c.baseball.domain.Baseball;
import com.sang5c.baseball.ui.InputView;
import com.sang5c.baseball.ui.ResultView;

public class NumericalBaseball {
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        String userContinueInput;
        do {
            Baseball baseBall = Computer.randomBaseball();
            System.out.println("question : " + baseBall);

            startUserInteraction(baseBall);
            userContinueInput = InputView.getInputToContinue();
        } while (isNotExit(userContinueInput));
    }

    private static boolean isNotExit(String userContinueInput) {
        return !EXIT.equalsIgnoreCase(userContinueInput);
    }

    private static void startUserInteraction(Baseball baseBall) {
        BaseballCount baseballCount;
        do {
            String userInput = InputView.getUserNumbersInput();
            Baseball userBaseball = Baseball.of(userInput);

            baseballCount = baseBall.compare(userBaseball);
            ResultView.printCount(baseballCount);
        } while (!baseballCount.isThreeStrike());
    }


}
