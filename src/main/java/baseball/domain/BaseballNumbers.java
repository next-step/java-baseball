package baseball.domain;

import baseball.exception.BaseballNumbersHasDuplicationException;
import baseball.exception.BaseballNumbersHasInvalidLength;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int COUNT_OF_BASEBALL_NUMBERS = 3;
    private Set<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = new LinkedHashSet<BaseballNumber>();
        setValue(baseballNumbers);
        validate(baseballNumbers);
    }

    private void setValue(List<BaseballNumber> baseballNumbers) {
        for (BaseballNumber baseballNumber : baseballNumbers) {
            this.baseballNumbers.add(baseballNumber);
        }
    }

    private void validate(List<BaseballNumber> baseballNumbers) {
        validateDuplication(baseballNumbers);
        validateLength();
    }

    private void validateLength() {
        if (getSize() != COUNT_OF_BASEBALL_NUMBERS) {
            throw new BaseballNumbersHasInvalidLength();
        }
    }

    private void validateDuplication(List<BaseballNumber> baseballNumbers) {
        if (getSize() < baseballNumbers.size()) {
            throw new BaseballNumbersHasDuplicationException();
        }
    }

    public Set<BaseballNumber> getValue() {
        return baseballNumbers;
    }

    public int getSize() {
        return baseballNumbers == null ? 0 : baseballNumbers.size();
    }
}
