package baseball.domain;

import java.util.*;
import java.util.function.Consumer;

public class BaseballNumbers implements Iterable<BaseballNumber> {

    public static final int SIZE = 3;
    public static final int MIN_INDEX = 0;

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers() {
        this(generateBaseballNumbers(new ShuffleNumberGenerateStrategy()));
    }

    public BaseballNumbers(NumberGenerateStrategy numberGenerateStrategy) {
        this(generateBaseballNumbers(numberGenerateStrategy));
    }

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private static void validate(List<?> baseballNumbers) {
        if (baseballNumbers == null) {
            throw new IllegalArgumentException("숫자 정보를 입력해 주세요.");
        }
        if (baseballNumbers.size() != SIZE) {
            throw new IllegalArgumentException("숫자는 " + SIZE + " 개로 이루어져야 합니다.");
        }
        if (baseballNumbers.size() > calculateDistinctSize(baseballNumbers)) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다. 입력값을 확인해 주세요.");
        }
    }

    private static List<BaseballNumber> generateBaseballNumbers(NumberGenerateStrategy numberGenerateStrategy) {
        validate(numberGenerateStrategy);
        return generateBaseballNumbers(numberGenerateStrategy.generateNumbers());
    }

    private static void validate(NumberGenerateStrategy shuffleNumberGenerateStrategy) {
        if (shuffleNumberGenerateStrategy == null) {
            throw new IllegalArgumentException("숫자 생성 전략을 입력해 주세요.");
        }
    }

    private static List<BaseballNumber> generateBaseballNumbers(List<Integer> numbers) {
        validate(numbers);
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            baseballNumbers.add(new BaseballNumber(number));
        }
        return baseballNumbers;
    }

    private static int calculateDistinctSize(List<?> baseballNumbers) {
        return new HashSet<>(baseballNumbers).size();
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
            containsCount = getContainsCount(attackNumber);
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
