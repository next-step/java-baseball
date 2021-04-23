package baseball;

import util.RandomGenerator;

import java.util.List;

public class BaseBallGame {
    private final int MAX_STRIKE_COUNT = 3;
    private final String INVALID_ARGUMENT_MESSAGE = "입력값은 중복되지 않은 세자리의 숫자여야 합니다.";
    private final List<Integer> numbers;
    private int strikeCount;
    private int ballCount;

    public BaseBallGame(RandomGenerator randomGenerator) {
        this.numbers = randomGenerator.makeNumbersLessThanTen();
    }

    public boolean isCompleted() {
        return strikeCount == MAX_STRIKE_COUNT;
    }

    public String guess(String str) {
        checkArgument(str);
        int length = str.length();
        for (int index = 0; index < length; index++) {
            int input = str.charAt(index) - '0';
            matchStrike(input, index);
            matchBall(input, index);
        }

        return printMessage();
    }

    private void matchStrike(int input, int index) {
        if (numbers.get(index).equals(input)) {
            strikeCount++;
        }
    }

    private void matchBall(int input, int index) {
        if (!numbers.get(index).equals(input) && numbers.contains(input)) {
            ballCount++;
        }
    }

    private void checkArgument(String str) {
        if (!BaseBallInputValidator.isIsValid(str)) {
            throw new IllegalArgumentException(INVALID_ARGUMENT_MESSAGE);
        }
        clearGameCount();
    }

    private void clearGameCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    private String printMessage() {
        String strike = getStrikeMessage();
        String ball = getBallMessage();

        return (strikeCount == 0 && ballCount == 0) ? BaseBall.NOTHING.getValue() : strike + ball;
    }

    private String getStrikeMessage() {
        String result = strikeCount > 0 ? strikeCount + " " + BaseBall.STRIKE.getValue() : "";
        if (strikeCount > 0 && ballCount > 0) {
            result = result + " ";
        }

        return result;
    }

    private String getBallMessage() {
        return ballCount > 0 ? ballCount + " " + BaseBall.BALL.getValue() : "";
    }
}
