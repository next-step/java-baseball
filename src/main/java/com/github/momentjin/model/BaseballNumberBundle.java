package com.github.momentjin.model;

import java.util.List;

public class BaseballNumberBundle {

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumberBundle(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public int size() {
        return baseballNumbers.size();
    }

    public BaseballNumber getBaseballNumber(int index) {
        return baseballNumbers.get(index);
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }

    public boolean isStrike(int index, BaseballNumber target) {

        BaseballNumber originNumber = this.getBaseballNumber(index);
        return originNumber.equals(target);
    }

    public boolean isBall(int index, BaseballNumber target) {

        BaseballNumber originNumber = this.getBaseballNumber(index);
        return this.baseballNumbers.contains(target) && !originNumber.equals(target);
    }
}
