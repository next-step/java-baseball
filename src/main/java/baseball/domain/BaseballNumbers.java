package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {

    private static final int SIZE = 3;
    public static final int MIN_INDEX = 0;
    public static final int MAX_INDEX = SIZE - 1;

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
}
