public class Computer {
    private final RightAnswer answer;

    public Computer(int numberSize) {
        this.answer = new RightAnswer(RandomNumberGenerator.generate(numberSize));
    }

    public int getNumberSize() {
        return answer.getNumber().length();
    }

    public boolean isCorrectAnswer() {
        return answer.isCorrect();
    }

    public Result compareNumberWith(String input) {
        Result result = new Result();

        for (int i = 0; i < getNumberSize(); i++) {
            calculate(result, input.charAt(i), i);
        }

        return result;
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
            answer.setCorrect();
        }
    }
}
