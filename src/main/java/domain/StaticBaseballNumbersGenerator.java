package domain;

import domain.exceptions.BaseballNumberDuplicatedException;

import java.util.*;

public class StaticBaseballNumbersGenerator implements BaseballNumbersGenerator {
    private final List<Integer> values;

    public StaticBaseballNumbersGenerator(int first, int second, int third) {
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

    private void validateDuplicatedNumber(Set<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != 3) {
            throw new BaseballNumberDuplicatedException();
        }
    }
}
