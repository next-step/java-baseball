package baseball.domain;

import java.util.List;

@FunctionalInterface
public interface BallGenerateStrategy {

    List<Integer> generate();
}
