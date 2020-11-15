package baseball.domain.strategy;

import baseball.exception.IllegalBallNumberException;

import java.util.*;

public class ThreeBallGenerateStrategy implements BallGenerateStrategy {

    private static final int START_INDEX = 0;
    private static final int LOOP_INDEX = 30;
    private static final int BALL_NUMBER_SIZE = 3;
    private static final String DUPLICATION_MESSAGE = "랜덤 숫자 3개가 생성 되어야 합니다.";

    private final RandomNumberStrategy strategy;

    public ThreeBallGenerateStrategy(final RandomNumberStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = START_INDEX; i < LOOP_INDEX; i++) {
            numbers.add(this.strategy.generate());
        }

        numbers = changeBallNumber(numbers);

        validateSize(numbers);

        return Collections.unmodifiableList(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (Objects.isNull(numbers) || numbers.size() != BALL_NUMBER_SIZE) {
            throw new IllegalBallNumberException(DUPLICATION_MESSAGE);
        }
    }

    private List<Integer> changeBallNumber(List<Integer> numbers) {
        Set<Integer> target = new LinkedHashSet<>(numbers);

        if (target.size() < BALL_NUMBER_SIZE) {
            throw new IllegalBallNumberException(DUPLICATION_MESSAGE);
        }

        return new ArrayList<>(target).subList(START_INDEX, BALL_NUMBER_SIZE);
    }

}
