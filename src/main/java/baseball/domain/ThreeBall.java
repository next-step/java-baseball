package baseball.domain;

import baseball.domain.strategy.BallGenerateStrategy;
import baseball.exception.BallException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ThreeBall {

    private static final String CONSTRUCT_ERROR_MESSAGE = "공 생성에 실패 하였습니다.";

    private List<BallNumber> balls;

    public ThreeBall(final BallGenerateStrategy strategy) {
        List<BallNumber> result = new ArrayList<>();

        validateStrategy(strategy);
        List<Integer> numbers = strategy.generate();

        for (Integer number : numbers) {
            result.add(new BallNumber(number));
        }

        this.balls = Collections.unmodifiableList(result);
    }

    private void validateStrategy(final BallGenerateStrategy strategy) {
        if (Objects.isNull(strategy)) {
            throw new BallException(CONSTRUCT_ERROR_MESSAGE);
        }
    }

}
