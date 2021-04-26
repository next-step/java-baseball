public class GameController {

    void gameControl() {
        String input;

        do {
            GameView.printStartMessage();
            String generatedNumber = generateNumber();
            matchNumber(generatedNumber);
            input = GameView.printGameOver();
        } while (!input.equals("1"));
    }

    private void matchNumber(String generatedNumber) {
        NumberMatcher numberMatcher;

        do {
            String inputNumber = requestInputNumber();
            numberMatcher = new NumberMatcher(inputNumber, generatedNumber);
            numberMatcher.matchNumber();
            getResult(numberMatcher);
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

    private void getResult(NumberMatcher numberMatcher) {
        if (numberMatcher.isFourBall()) {
            GameView.printFourBall();
            return;
        }

        GameView.printStrikeBall(numberMatcher.getStrike(), numberMatcher.getBall());
    }
}
