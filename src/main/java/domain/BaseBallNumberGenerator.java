package domain;

import java.util.List;

@FunctionalInterface
public interface BaseBallNumberGenerator {
    List<BaseBallNumber> getNumbers();
}
