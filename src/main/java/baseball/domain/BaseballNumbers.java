package baseball.domain;

import baseball.exception.BaseballNumbersHasDuplicationException;
import baseball.exception.BaseballNumbersHasInvalidLength;

import java.util.*;

import static baseball.domain.BaseballGameRule.COUNT_OF_BASEBALL_NUMBERS;

public class BaseballNumbers {

    private Set<BaseballNumber> baseballNumbers;

    private BaseballNumbers() {
    }

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        createBaseballNumbers(baseballNumbers);
    }

    public BaseballNumbers(String input) {
        List<BaseballNumber> baseballNumbers = asBaseballNumbers(input);
        createBaseballNumbers(baseballNumbers);
    }

    private void createBaseballNumbers(List<BaseballNumber> baseballNumbers) {
        setValue(baseballNumbers);
        validate(baseballNumbers);
    }

    private List<BaseballNumber> asBaseballNumbers(String input) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for (Character baseballNumber : input.toCharArray()) {
            baseballNumbers.add(new BaseballNumber(String.valueOf(baseballNumber)));
        }
        return baseballNumbers;
    }

    private void setValue(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = new LinkedHashSet<BaseballNumber>();
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

    public int getPosition(BaseballNumber targetBaseballNumber) {
        return searchTargetNumberPosition(baseballNumbers.iterator(), targetBaseballNumber);
    }

    private int searchTargetNumberPosition(Iterator<BaseballNumber> iterator, BaseballNumber targetNumber) {
        int idx = 0;
        int position = -1;
        while (iterator.hasNext() && position == -1) {
            position = getIdx(idx++, targetNumber, iterator.next());
        }
        return position;
    }

    private int getIdx(int idx, BaseballNumber targetNumber, BaseballNumber number) {
        return targetNumber.equals(number) ? idx : -1;
    }

    public boolean contains(BaseballNumber targetBaseballNumber) {
        return baseballNumbers.contains(targetBaseballNumber);
    }

}
