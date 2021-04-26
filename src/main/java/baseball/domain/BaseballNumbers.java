package baseball.domain;

import java.util.*;
import java.util.function.Consumer;

public class BaseballNumbers implements Iterable<BaseballNumber> {

    public static final int SIZE = 3;
    public static final int MIN_INDEX = 0;

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public int equalsCount(BaseballNumbers attackNumbers) {
        int equalsCount = 0;
        int index = 0;
        for (BaseballNumber attackNumber : attackNumbers) {
            equalsCount += getEqualsCount(attackNumber, index++);
        }
        return equalsCount;
    }

    private int getEqualsCount(BaseballNumber attackNumber, int index) {
        if (attackNumber.equals(this.baseballNumbers.get(index))) {
            return 1;
        }
        return 0;
    }

    public int containsCount(BaseballNumbers attackNumbers) {
        int containsCount = 0;
        for (BaseballNumber attackNumber : attackNumbers) {
            containsCount += getContainsCount(attackNumber);
        }
        return containsCount;
    }

    private int getContainsCount(BaseballNumber attackNumber) {
        if (this.baseballNumbers.contains(attackNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public Iterator<BaseballNumber> iterator() {
        return baseballNumbers.iterator();
    }

    @Override
    public void forEach(Consumer<? super BaseballNumber> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<BaseballNumber> spliterator() {
        return Iterable.super.spliterator();
    }
}
