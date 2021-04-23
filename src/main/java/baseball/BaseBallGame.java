package baseball;

import util.RandomGenerator;

import java.util.List;

public class BaseBallGame {
    private final int MAX_STRIKE_COUNT = 3;
    private final List<Integer> numbers;
    private int strikeCount = 0;
    private int ballCount = 0;

    public BaseBallGame(RandomGenerator randomGenerator) {
        this.numbers = randomGenerator.makeNumbersLessThanTen();
    }

    public boolean isCompleted() {
        return strikeCount == MAX_STRIKE_COUNT;
    }

    public String guess(String str) {
        int length = numbers.size();
        for (int index = 0; index < length; index++) {
            matchStrike(str.charAt(index) - '0', index);
        }

        return printMessage();
    }

    private void matchStrike(int input, int index) {
        if (numbers.get(index).equals(input)) {
            strikeCount++;
        }
    }

    private String printMessage() {
        String message = BaseBall.NOTHING.getValue();
        if (strikeCount > 0) {
            message = strikeCount + " " + BaseBall.STRIKE.getValue();
        }

        if (ballCount > 0) {
            message = BaseBall.BALL.getValue();
        }

        return message;
    }
}
