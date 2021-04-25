package baseball.domain;

import baseball.exception.BaseballNumbersHasDuplicationException;
import baseball.exception.BaseballNumbersHasInvalidLength;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.BaseballGameRule.COUNT_OF_BASEBALL_NUMBERS;

public class BaseballNumbers {

    private Set<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = new LinkedHashSet<BaseballNumber>();
        setValue(baseballNumbers);
        validate(baseballNumbers);
    }

    public BaseballNumbers(String baseballNumbers) {
        // TODO
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
        if (getSize() != COUNT_OF_BASEBALL_NUMBERS.getValue()) {
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
