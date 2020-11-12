package domain;

import domain.exceptions.BaseballNumberDuplicatedException;

import java.util.*;

public class MockBaseballNumbersGenerator implements BaseballNumbersGenerator {
    private final List<Integer> values;

    public MockBaseballNumbersGenerator(int first, int second, int third) {
        this.values = Arrays.asList(first, second, third);
    }

    @Override
    public BaseballNumbers generate() {
        Set<BaseballNumber> baseballNumbers = new HashSet<>();

        for (Integer value : values) {
            baseballNumbers.add(BaseballNumber.of(value));
        }

        validateDuplicatedNumber(baseballNumbers);

        return new BaseballNumbers(new ArrayList<>(baseballNumbers));
    }

    public boolean isGenerated() {
        return (this.values.size() == 3);
    }

    private void validateDuplicatedNumber(Set<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != 3) {
            throw new BaseballNumberDuplicatedException();
        }
    }
}
