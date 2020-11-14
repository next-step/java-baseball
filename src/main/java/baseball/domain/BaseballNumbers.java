package baseball.domain;

import java.util.*;

public class BaseballNumbers {
    public static final int MIN_NUMBER = 100;
    public static final int MAX_NUMBER = 999;
    public static final int SIZE = 3;
    private final List<BaseballNumber> baseballNumbers;

    public static BaseballNumbers from(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
        return new BaseballNumbers(Arrays.asList(
                new BaseballNumber(1, new Number(number / 100)),
                new BaseballNumber(2, new Number(number / 10 % 10)),
                new BaseballNumber(3, new Number(number % 10))
        ));
    }

    public static BaseballNumbers from(final List<Number> numbers) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            int index = i + 1;
            baseballNumbers.add(new BaseballNumber(index, numbers.get(i)));
        }
        return new BaseballNumbers(baseballNumbers);
    }

    public BaseballNumbers(final List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != SIZE) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
        this.baseballNumbers = Collections.unmodifiableList(new ArrayList<>(baseballNumbers));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseballNumbers)) return false;
        final BaseballNumbers that = (BaseballNumbers) o;
        return Objects.equals(baseballNumbers, that.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }
}
