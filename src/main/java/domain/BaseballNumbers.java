package domain;

import domain.exceptions.InvalidBaseballNumbersSizeException;

import java.util.List;

public class BaseballNumbers {
    private final int BASEBALL_NUMBER_SIZE = 3;
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public int countMatchNumbers(BaseballNumbers compareTarget) {
        int count = 0;
        for (BaseballNumber baseballNumber : baseballNumbers) {
            count += getCount(compareTarget, baseballNumber);
        }
        return count;
    }

    public int countExactMatch(BaseballNumbers compareTarget) {
        int count = 0;
        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i ++) {
            BaseballNumber number = this.baseballNumbers.get(i);
            BaseballNumber compareTargetNumber = compareTarget.baseballNumbers.get(i);
            count += number.countSameNumber(compareTargetNumber);
        }
        return count;
    }

    private int getCount(BaseballNumbers compareTarget, BaseballNumber baseballNumber) {
        if (compareTarget.baseballNumbers.contains(baseballNumber)) {
            return 1;
        }
        return 0;
    }

    private void validateSize(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != 3) {
            throw new InvalidBaseballNumbersSizeException();
        }
    }
}
