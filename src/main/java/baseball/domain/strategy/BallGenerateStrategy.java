package baseball.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface BallGenerateStrategy {

    List<Integer> generate();
}
