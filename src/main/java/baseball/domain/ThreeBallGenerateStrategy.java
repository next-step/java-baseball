package baseball.domain;

import baseball.util.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeBallGenerateStrategy implements BallGenerateStrategy {

    private static final int BALL_NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private List<Integer> numbers = new ArrayList<>();

    @Override
    public List<Integer> generate() {
        while (numbers.size() < BALL_NUMBER_SIZE) {
            addNumber();
        }

        return Collections.unmodifiableList(numbers);
    }

    private void addNumber() {
        int randomNumber = RandomUtils.getRandomNumber(MIN_NUMBER, MAX_NUMBER);

        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
