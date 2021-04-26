package kr.insup.controller;

import kr.insup.domain.InputNumberValidator;
import kr.insup.domain.NumberGenerator;
import kr.insup.domain.NumberMatcher;
import kr.insup.view.GameView;

public class GameController {

    public void startGame() {
        String input;

        do {
            GameView.printStartMessage();
            String generatedNumber = generateNumber();
            matchNumber(generatedNumber);
            input = GameView.printGameOverAndAskRestart();
        } while (!input.equals("1"));
    }

    private void matchNumber(String generatedNumber) {
        NumberMatcher numberMatcher;

        do {
            String inputNumber = requestInputNumber();
            numberMatcher = new NumberMatcher(inputNumber, generatedNumber);
            numberMatcher.matchNumber();
            showResult(numberMatcher);
        } while (!numberMatcher.isMatch());
    }

    private String generateNumber() {
        String generatedNumber = NumberGenerator.generateNumber();
        GameView.printNumberGenerated();

        return generatedNumber;
    }

    private String requestInputNumber() {
        String inputNumber;

        do {
            inputNumber = GameView.requestInputNumber();
        } while (!validateInputNumber(inputNumber));

        return inputNumber;
    }

    private boolean validateInputNumber(String inputNumber) {
        boolean isValid = InputNumberValidator.validateNumber(inputNumber);

        if (!isValid) {
            GameView.printWrongInputNumber();
        }

        return isValid;
    }

    private void showResult(NumberMatcher numberMatcher) {
        if (numberMatcher.isFourBall()) {
            GameView.printFourBall();
            return;
        }

        GameView.printStrikeBall(numberMatcher.getStrike(), numberMatcher.getBall());
    }
}
