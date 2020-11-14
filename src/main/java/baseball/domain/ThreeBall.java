package baseball.domain;

import baseball.domain.strategy.BallGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeBall {

    private List<BallNumber> balls;

    public ThreeBall(final BallGenerateStrategy strategy) {
        List<BallNumber> result = new ArrayList<>();
        List<Integer> numbers = strategy.generate();

        for (Integer number : numbers) {
            result.add(new BallNumber(number));
        }

        this.balls = Collections.unmodifiableList(result);
    }

}
