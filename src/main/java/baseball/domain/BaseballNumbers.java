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

    public int equalsCount(BaseballNumbers pitchNumbers) {
        int equalsCount = 0;
        int index = 0;
        for (BaseballNumber pitchNumber : pitchNumbers) {
            equalsCount += getEqualsCount(pitchNumber, index++);
        }
        return equalsCount;
    }

    private int getEqualsCount(BaseballNumber pitchNumber, int index) {
        if (pitchNumber.equals(this.baseballNumbers.get(index))) {
            return 1;
        }
        return 0;
    }

    public int containsCount(BaseballNumbers pitchNumbers) {
        int containsCount = 0;
        for (BaseballNumber pitchNumber : pitchNumbers) {
            containsCount += getContainsCount(pitchNumber);
        }
        return containsCount;
    }

    private int getContainsCount(BaseballNumber pitchNumbers) {
        if (this.baseballNumbers.contains(pitchNumbers)) {
            return 1;
        }
        return 0;
    }

    public int size() {
        return this.baseballNumbers.size();
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
