package com.sang5c.baseball;

import com.sang5c.baseball.domain.Computer;
import com.sang5c.baseball.domain.Count;
import com.sang5c.baseball.domain.Numbers;
import com.sang5c.baseball.ui.InputView;
import com.sang5c.baseball.ui.ResultView;

public class NumericalBaseBall {

    public static void main(String[] args) {
        String userContinueInput;
        do {
            // 서로 다른 1~9 랜덤 숫자 세개 출력 -> 입력받았다고 생각하기.
            // String computer = "146"; // TODO: random
            Numbers question = Computer.randomNumbers();
            System.out.println("question : " + question);

            startUserInteraction(question);
            userContinueInput = InputView.getInputToContinue();
        } while ("exit".equalsIgnoreCase(userContinueInput)); // TODO: 반대로
    }

    private static void startUserInteraction(Numbers question) {
        Count count;
        do {
            String userInput = InputView.getUserNumbersInput();
            Numbers userNumbers = Numbers.of(userInput);

            count = question.compare(userNumbers);
            ResultView.printCount(count);
        } while (!count.isThreeStrike());
    }


}
