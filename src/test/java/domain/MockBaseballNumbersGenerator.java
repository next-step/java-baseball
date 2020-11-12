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
        List<BaseballNumber> baseballNumbers = new ArrayList<>();

        for (Integer value : values) {
            baseballNumbers.add(BaseballNumber.of(value));
        }

        validateDuplicatedNumber(baseballNumbers);

        return new BaseballNumbers(new ArrayList<>(baseballNumbers));
    }

    public boolean isGenerated() {
        return (this.values.size() == 3);
    }

    private void validateDuplicatedNumber(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> dupRemoved = new HashSet<>(baseballNumbers);
        if (dupRemoved.size() != 3) {
            throw new BaseballNumberDuplicatedException();
        }
    }
}
