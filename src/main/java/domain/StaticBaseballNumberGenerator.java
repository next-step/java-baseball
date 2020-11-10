package domain;

import domain.exceptions.BaseballNumberDuplicatedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StaticBaseballNumberGenerator implements BaseballNumberGenerator {
    private final List<Integer> values;

    public StaticBaseballNumberGenerator(int first, int second, int third) {
        this.values = Arrays.asList(first, second, third);
    }

    @Override
    public Set<BaseballNumber> generate() {
        Set<BaseballNumber> baseballNumbers = new HashSet<>();

        for (Integer value : values) {
            baseballNumbers.add(BaseballNumber.of(value));
        }

        validateDuplicatedNumber(baseballNumbers);

        return baseballNumbers;
    }

    private void validateDuplicatedNumber(Set<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != 3) {
            throw new BaseballNumberDuplicatedException();
        }
    }
}
