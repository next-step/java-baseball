package domain.generator;

import domain.number.BaseBallNumber;

import java.util.List;

@FunctionalInterface
public interface BaseBallNumberGenerator {
    List<BaseBallNumber> getNumbers();
}
