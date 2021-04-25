package baseball;

import java.util.Set;
import java.util.TreeSet;

public class BaseballNumber {
    private final Set<Integer> baseballNumbers;

    BaseballNumber() {
        this.baseballNumbers = new TreeSet<>();
    }

    public void addBaseballNumber(Integer number) {
        if (!isRangeOneToNine(number)) {
            throw new IllegalArgumentException("숫자의 범위는 1이상, 9이하 입니다.");
        }
        baseballNumbers.add(number);
    }

    private boolean isRangeOneToNine(Integer number) {
        return number >= 1 && number <= 9;
    }

    public int size() {
        return baseballNumbers.size();
    }
}
