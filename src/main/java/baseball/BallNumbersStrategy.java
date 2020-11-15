package baseball;

import java.util.Set;

@FunctionalInterface
public interface BallNumbersStrategy {
    Set<Integer> getBallNumber();
}
