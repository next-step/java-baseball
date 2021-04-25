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

    public List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }
}
