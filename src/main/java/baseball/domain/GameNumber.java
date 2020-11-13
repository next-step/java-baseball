package baseball.domain;

import baseball.validator.GameNumberValidator;
import baseball.validator.Validatable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameNumber {
    public static final int MINIMUM_GAME_NUMBER = 1;
    public static final int MAXIMUM_GAME_NUMBER = 9;

    private static final Validatable<Integer> validator = new GameNumberValidator();
    private static final Map<Integer, GameNumber> numberPool = new HashMap<>();

    private final Integer number;

    private GameNumber(Integer number) {
        validator.validate(number);
        this.number = number;
    }

    public static GameNumber getInstance(Integer number) {
        return numberPool.getOrDefault(number, new GameNumber(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameNumber that = (GameNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
