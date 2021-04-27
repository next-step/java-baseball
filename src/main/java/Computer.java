public class Computer {
    private final static String ERROR_FORMAT = "정확한 값을 입력해주세요. 현재 입력값 : %s";
    private final RightAnswer answer;
    private final String regularExpression;

    public Computer(RightAnswer answer, String regularExpression) {
        this.answer = answer;
        this.regularExpression = regularExpression;
    }

    public int getNumberSize() {
        String number = answer.getNumber();
        return number.length();
    }

    public Result compareNumberWith(String input) {
        validateInput(input);
        Result result = new Result();

        for (int i = 0; i < getNumberSize(); i++) {
            calculate(result, input.charAt(i), i);
        }

        return result;
    }

    private void validateInput(String input) {
        if (!input.matches(regularExpression)) {
            String message = String.format(ERROR_FORMAT, input);
            throw new IllegalArgumentException(message);
        }
    }

    private void calculate(Result result, char singleDigit, int index) {
        int answerIndex = answer.getNumber().indexOf(singleDigit);

        if (answerIndex == index) {
            increaseStrikeCount(result);
        }

        if (answerIndex != index && answerIndex != -1) {
            result.increaseBallCount();
        }
    }

    private void increaseStrikeCount(Result result) {
        result.increaseStrikeCount();

        if (result.getStrikeCount() == getNumberSize()) {
            result.doSuccess();
        }
    }
}
